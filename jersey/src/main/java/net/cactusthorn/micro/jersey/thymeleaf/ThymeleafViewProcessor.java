package net.cactusthorn.micro.jersey.thymeleaf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.internal.inject.InjectionManager;
import org.glassfish.jersey.server.mvc.Viewable;
import org.glassfish.jersey.server.mvc.spi.TemplateProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafViewProcessor implements TemplateProcessor<String> {

    private static final Logger LOG = LoggerFactory.getLogger(ThymeleafViewProcessor.class);

    private ITemplateEngine templateEngine;
    private volatile InjectionManager injectionManager;
    private volatile ServletContext servletContext;

    @Inject //
    public ThymeleafViewProcessor(InjectionManager injectionManager) {

        this.injectionManager = injectionManager;
        this.servletContext = injectionManager.getInstance(ServletContext.class);

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));
        templateResolver.setCacheable(true);

        TemplateEngine engine = new TemplateEngine();
        engine.setTemplateResolver(templateResolver);

        templateEngine = engine;

        LOG.info("INITIALIZED!");

    }

    @Override //
    public String resolve(String templatePath, MediaType mediaType) {
        return templatePath;
    }

    @Override //
    public void writeTo(String templateReference, Viewable viewable, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
            OutputStream out) throws IOException {

        HttpServletRequest request = injectionManager.getInstance(HttpServletRequest.class);
        HttpServletResponse response = injectionManager.getInstance(HttpServletResponse.class);

        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());

        Map<String, Object> variables = new HashMap<>();
        variables.put("model", viewable.getModel());
        ctx.setVariables(variables);

        templateEngine.process(templateReference, ctx, new OutputStreamWriter(out, StandardCharsets.UTF_8));

    }

}
