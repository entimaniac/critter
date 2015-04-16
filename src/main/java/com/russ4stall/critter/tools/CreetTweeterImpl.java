package com.russ4stall.critter.tools;

import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.GroupTwitterCredentials;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 *
 * @author Russ Forstall
 */
public class CreetTweeterImpl implements CreetTweeter {
    @Override
    public void publishToTwitter(Creet creet, GroupTwitterCredentials credentials) throws TwitterException {

        TwitterFactory tf = new TwitterFactory(TwitterConfigFactory.getConfig());
        Twitter twitter = tf.getInstance();

        AccessToken accessToken = new AccessToken(credentials.getToken(), credentials.getTokenSecret());
        twitter.setOAuthAccessToken(accessToken);

        twitter.updateStatus(creet.getMessage());
    }
}
