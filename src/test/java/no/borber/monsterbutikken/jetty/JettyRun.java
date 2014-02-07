package no.borber.monsterbutikken.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyRun {

    public static void main(String... args) throws Exception {

        Server server = new Server(9090);

        WebAppContext context = new WebAppContext("src/main/webapp", "/");
        server.setHandler(context);

        server.start();
        server.join();

        server.setStopAtShutdown(true);
    }
}
