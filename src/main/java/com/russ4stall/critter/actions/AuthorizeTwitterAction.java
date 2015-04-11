package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.GroupTwitterCredentials;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import com.russ4stall.critter.db.GroupTwitterCredentialsDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.util.Map;

/**
 * Redirects users to twitter to authorize Critter.
 *
 * Created by russ on 4/9/15.
 */

@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class AuthorizeTwitterAction extends ActionSupport implements SessionAware {
    private String groupId;

    private String oauthToken;
    private String oauthVerifier;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();

        RequestToken requestToken = (RequestToken) session.get("requestToken");

        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);

        try (GroupTwitterCredentialsDao groupTwitterCredentialsDao = new DbiFactory().getDbi().open(GroupTwitterCredentialsDao.class)) {
            groupTwitterCredentialsDao.createGroupTwitterCredentials(groupId, accessToken.getToken(), accessToken.getTokenSecret());
        }

        return SUCCESS;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setOauth_token(String oauth_token) {
        this.oauthToken = oauth_token;
    }

    public void setOauth_verifier(String oauth_verifier) {
        this.oauthVerifier = oauth_verifier;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
