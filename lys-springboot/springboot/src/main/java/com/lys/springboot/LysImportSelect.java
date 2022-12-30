package com.lys.springboot;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class LysImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 自动配置   java spi
        ServiceLoader<AutoConfiguration> loader = ServiceLoader.load(AutoConfiguration.class);
        List<String> list = new ArrayList<>();
        for (AutoConfiguration configuration : loader) {
            list.add(configuration.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}
