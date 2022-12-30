package com.lys.springboot;

public class JettyWebServer implements WebServer {
    @Override
    public void strat() {
        System.out.println("启动Jetty");
    }
}
