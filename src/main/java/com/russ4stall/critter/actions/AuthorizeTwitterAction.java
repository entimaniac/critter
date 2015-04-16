package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupTwitterCredentialsDao;
import com.russ4stall.critter.tools.TwitterConfigFactory;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Gets authorization tokens from twitter.
 *
 * Created by russ on 4/9/15.
 */

@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class AuthorizeTwitterAction extends ActionSupport implements SessionAware {
    private String groupId;
    private String denied;

    private String oauthToken;
    private String oauthVerifier;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {

        if (!isEmpty(denied)) {
            //todo: inform user that authorization has been denied
            return SUCCESS;
        }

        TwitterFactory tf = new TwitterFactory(TwitterConfigFactory.getConfig());
        Twitter twitter = tf.getInstance();

        RequestToken requestToken = (RequestToken) session.get("requestToken");

        AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);

        try (GroupTwitterCredentialsDao groupTwitterCredentialsDao = new DbiFactory().getDbi().open(GroupTwitterCredentialsDao.class)) {
            groupTwitterCredentialsDao.createGroupTwitterCredentials(
                    groupId,
                    accessToken.getScreenName(),
                    accessToken.getUserId(),
                    accessToken.getToken(),
                    accessToken.getTokenSecret()
            );
        }

        //todo: inform user that authorization was successful
        return SUCCESS;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setDenied(String denied) {
        this.denied = denied;
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
