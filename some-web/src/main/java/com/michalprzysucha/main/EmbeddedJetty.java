package com.michalprzysucha.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Michal Przysucha
 * @since 2015-03-29
 */
public class EmbeddedJetty {

    private static final int DEFAULT_PORT = 8089;

    public static void main(String[] args) throws Exception {
        new EmbeddedJetty().startJetty();
    }

    private void startJetty() throws Exception {
        Server server = new Server(DEFAULT_PORT);
        WebAppContext context = new WebAppContext();
        context.setDescriptor("some-web/src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase("some-web/src/main/webapp");
        context.setContextPath("/");
        server.setHandler(context);
        server.start();
        server.join();
    }

}
