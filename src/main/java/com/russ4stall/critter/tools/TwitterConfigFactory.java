package com.russ4stall.critter.tools;

import com.russ4stall.critter.utils.CritterProperties;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Factory for Twitter Configuration
 *
 * @author Russ Forstall
 */
public class TwitterConfigFactory {

    public static Configuration getConfig() {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CritterProperties.TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(CritterProperties.TWITTER_SECRET_KEY);

        return cb.build();
    }

}
