package com.russ4stall.critter.utils;

import ognl.OgnlRuntime;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 *
 * @author Russ Forstall
 */
@SuppressWarnings("JavaDoc")
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    /**
     * Runs on application startup.
     *
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
        Flyway flyway = new Flyway();
        flyway.setDataSource(
                CritterProperties.DB_URL,
                CritterProperties.DB_USER,
                CritterProperties.DB_PASSWORD
        );
        flyway.setValidateOnMigrate(false);
        flyway.migrate();

    }

    /**
     * Runs on application shutdown.
     *
     * @param sce
     */
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
