package com.baidu.hugegraph.logger;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.util.Set;

public class TemplateLoggerAnnotationProcessor extends AbstractProcessor {

    private Filer filter;
    private Elements elements;

    @Override
    public synchronized void init(ProcessingEnvironment environment) {
        super.init(environment);
        this.elements = environment.getElementUtils();
        this.filter = environment.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
