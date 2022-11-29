package main;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import servlets.HelloServlet;

import java.io.File;

/**
 * @author imironov
 * @since 14.11.2022
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setHostname("localhost");
        String appBase = ".";
        tomcat.getHost().setAppBase(appBase);

        File docBase = new File(System.getProperty("java.io.tmpdir"));
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        Class<?> servletClass = HelloServlet.class;
        Tomcat.addServlet(context, servletClass.getSimpleName(), servletClass.getName());
        context.addServletMappingDecoded(
            "/my-servlet/*", servletClass.getSimpleName());

        tomcat.start();
        tomcat.getServer().await();
    }
}
