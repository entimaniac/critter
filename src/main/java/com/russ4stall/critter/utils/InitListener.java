package com.russ4stall.critter.utils;

import ognl.OgnlRuntime;
import org.flywaydb.core.Flyway;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 *
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/critter", "critter", "critter");
        flyway.setValidateOnMigrate(false);
        flyway.migrate();

    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
