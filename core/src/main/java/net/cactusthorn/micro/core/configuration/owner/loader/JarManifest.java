package net.cactusthorn.micro.core.configuration.owner.loader;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;

import org.aeonbits.owner.loaders.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Example: jar:///manifest?Application-Name=MICRO
public class JarManifest implements Loader {

    private static final long serialVersionUID = 0L;

    private static final Logger LOG = LoggerFactory.getLogger(JarManifest.class);

    private static final String SCHEMA = "jar";
    private static final String PATH = "/manifest";

    @Override
    public boolean accept(URI uri) {
        return SCHEMA.equals(uri.getScheme()) && PATH.equals(uri.getPath());
    }

    @Override
    public void load(Properties result, URI uri) throws IOException {

        String[] parts = uri.getQuery().split("=");
        String name = parts[0];
        String value = parts.length > 1 ? parts[1] : null;

        Enumeration<URL> urls = getClass().getClassLoader().getResources(JarFile.MANIFEST_NAME);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            try (InputStream in = url.openStream()) {

                Manifest manifest = new Manifest(in);
                Attributes attributes = manifest.getMainAttributes();
                String attribute = attributes.getValue(name);
                if (value == null || value.equals(attribute)) {

                    LOG.info("Manifest for {}={} found.", name, value);

                    for (Map.Entry<Object, Object> entry : attributes.entrySet()) {
                        result.put(entry.getKey().toString(), entry.getValue().toString());
                    }
                    return;
                }
            }
        }

        if (value != null ) {
            LOG.warn("Manifest for {}={} NOT found.", name, value);
        } else {
            LOG.warn("Manifest for {} NOT found.", name);
        }
    }

    @Override
    public String defaultSpecFor(String uriPrefix) {
        return null;
    }

}
