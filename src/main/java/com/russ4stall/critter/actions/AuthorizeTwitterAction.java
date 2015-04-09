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
 * GET
 * Redirects users to twitter to authorize Critter.
 *
 * POST
 * Retrieve and persist access token.
 *
 * Created by russ on 4/9/15.
 */
@Results({
        @Result(name="input", location = "${authorizationURL}", type = "redirect"),
        @Result(name="success", location="/landing-page", type = "redirect")
})
public class AuthorizeTwitterAction extends ActionSupport implements SessionAware {
    private String authorizationURL;
    private String groupId;

    private String oauthToken;
    private String oauthVerifier;

    Map<String, Object> session;

    @Override
    public String input() throws Exception {
        User user = (User) session.get("user");
        Group group;
        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            group = groupDao.getGroupById(groupId);

            if (!user.getId().equals(group.getOwner())) {
                return "error";
            }
        }

        Twitter twitter = TwitterFactory.getSingleton();
        RequestToken requestToken;
        try {
            requestToken = twitter.getOAuthRequestToken("https://rabidwolves.com?groupId=" + groupId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        authorizationURL = requestToken.getAuthorizationURL();

        return INPUT;
    }

    @Override
    public String execute() throws Exception {
        Twitter twitter = TwitterFactory.getSingleton();
        AccessToken accessToken = twitter.getOAuthAccessToken(oauthToken, oauthVerifier);

        try (GroupTwitterCredentialsDao groupTwitterCredentialsDao = new DbiFactory().getDbi().open(GroupTwitterCredentialsDao.class)) {
            groupTwitterCredentialsDao.createGroupTwitterCredentials(groupId, accessToken.getToken(), accessToken.getTokenSecret());
        }

        return SUCCESS;
    }

    public String getAuthorizationURL() {
        return authorizationURL;
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
