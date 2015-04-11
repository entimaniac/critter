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


        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("EDlHZIkC6bJZWFbiP5F4YngFJ", "IrousFf2sQy1zaBavTrx5YaP4CzR73dPbm5MnNlyp96APvYcyM");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
