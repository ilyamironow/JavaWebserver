package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorServlet;

import java.util.logging.Logger;

/**
 * @author imironov
 * @since 29.11.2022
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(Main.class.getName());
        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mirrorServlet), "/mirror/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        logger.info("Server started");
    }
}
