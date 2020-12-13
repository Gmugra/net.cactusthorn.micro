package net.cactusthorn.micro.core.banner;

import java.io.*;
import java.nio.charset.StandardCharsets;

import javax.inject.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.cactusthorn.micro.core.configuration.AppInfo;

@Singleton
public class Banner {

    private static final Logger LOG = LoggerFactory.getLogger(Banner.class);

    public static final String BANNER_FILE = "banner.txt";
    public static final String LS = System.getProperty("line.separator");

    private AppInfo appInfo;
    private String banner;

    @Inject
    public Banner(AppInfo appInfo) {
        this.appInfo = appInfo;
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("banner.txt");
                Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(reader)) {

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.getProperty("line.separator"));
            }

            banner = stringBuilder.toString();
        } catch (IOException ioe) {
            LOG.warn("Impossible to show Banner", ioe);
        }
    }

    public void show() {
        if (!LOG.isInfoEnabled()) {
            return;
        }
        LOG.info("{}{}{}; Version: {}; Build-Time: {}{}", LS, banner, appInfo.title(), appInfo.version(), appInfo.buildTime(), LS);
    }
}
