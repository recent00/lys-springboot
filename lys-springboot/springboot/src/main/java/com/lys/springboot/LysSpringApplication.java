package com.lys.springboot;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


import java.util.Map;

public class LysSpringApplication {

    public static void run(Class clazz){
        // Spring容器
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(clazz);
        applicationContext.refresh();
        WebServer webServer = getWebServer(applicationContext);
        webServer.strat();
    }
    private static WebServer getWebServer(WebApplicationContext applicationContext) {
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);
        if (beansOfType.isEmpty()) {
            throw new NullPointerException("啥都没配");
        }
        if (beansOfType.size() > 1) {
            throw new IllegalStateException("拿到了多个");
        }
        return beansOfType.values().stream().findFirst().get();
    }
}
