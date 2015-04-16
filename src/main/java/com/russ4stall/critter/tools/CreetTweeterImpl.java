package com.russ4stall.critter.tools;

import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.GroupTwitterCredentials;
import com.russ4stall.critter.utils.CritterProperties;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Russ Forstall
 */
public class CreetTweeterImpl implements CreetTweeter {
    @Override
    public void publishToTwitter(Creet creet, GroupTwitterCredentials credentials) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(CritterProperties.TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(CritterProperties.TWITTER_SECRET_KEY);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        AccessToken accessToken = new AccessToken(credentials.getToken(), credentials.getTokenSecret());
        twitter.setOAuthAccessToken(accessToken);

        twitter.updateStatus(creet.getMessage());
    }
}
