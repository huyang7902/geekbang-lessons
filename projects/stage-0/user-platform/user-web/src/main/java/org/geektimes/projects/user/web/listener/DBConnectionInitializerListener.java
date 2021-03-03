package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context ic = new InitialContext();
            DataSource dataSource = (DataSource)ic.lookup("java:comp/env/jdbc/UserPlatformDB");
            DBConnectionManager.instance.setDataSource(dataSource);
            System.out.println("DBConnectionInitializerListener#contextInitialized init dataSource");
        } catch (NamingException e) {
            // javax.naming.NoInitialContextException: Need to specify class name in environment or system property,
            // or as an applet parameter, or in an application resource file:  java.naming.factory.initial
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
