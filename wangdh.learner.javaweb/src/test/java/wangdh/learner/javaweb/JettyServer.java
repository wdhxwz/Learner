package wangdh.learner.javaweb;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 用于开发调试
 */
public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server jettyServer = buildJettyServer(9999,"");
        jettyServer.start();
    }

    public static Server buildJettyServer(int port,String contextPath){
        Server server = new Server(port);

        WebAppContext webContext = new WebAppContext("src/main/webapp", contextPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(webContext);
        server.setStopAtShutdown(true);

        return server;
    }

}
