package org.platypus.builder.plugin.ui.plolymere.maven.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class FreeFusion {
    private static final long serialVersionUID = 9009257088998734595L;
    private Configuration cfg;
    private final Version version = new Version(2, 3, 25);

    public FreeFusion(Class classForTemplateLoader) {
        cfg = new Configuration(version);
        cfg.setClassForTemplateLoading(classForTemplateLoader, "");
        cfg.setObjectWrapper(new DefaultObjectWrapper(version));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setIncompatibleImprovements(version);
    }

    public String fusionRootAndTemplate(RootFreeMarker root,String nameTemplate){
        if(cfg==null){
            throw new RuntimeException("erreur appeler initConfig avant");
        }
        try {
            StringWriter sw  = new StringWriter();
            Template temp = cfg.getTemplate(nameTemplate);
            temp.process(root.getMap(), sw);
            return sw.getBuffer().toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("erreur fusionRootAndTemplate ", e);
        }
    }
//    public String fusionRootAndStringTemplate(RootFreeMarker root,String template){
//        try {
//            Configuration configuration = new Configuration(version);
//            StringWriter sw  = new StringWriter();
//            StringTemplateLoader loader = new StringTemplateLoader();
//            String keyTemplate = "template";
//            loader.putTemplate(keyTemplate, template);
//            configuration.setTemplateLoader(loader);
//            Template temp = configuration.getTemplate(keyTemplate);
//            temp.process(root, sw);
//            return sw.getBuffer().toString();
//        } catch (IOException | TemplateException e) {
//            throw new RuntimeException("erreur fusionRootAndStringTemplate ", e);
//        }
//    }
}
