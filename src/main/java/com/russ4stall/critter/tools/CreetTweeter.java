package com.russ4stall.critter.tools;

import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.GroupTwitterCredentials;
import twitter4j.TwitterException;

/**
 * Created by russellf on 4/9/2015.
 */
public interface CreetTweeter {
    void publishToTwitter(Creet creet, GroupTwitterCredentials credentials) throws TwitterException;
}
