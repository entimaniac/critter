package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import com.russ4stall.critter.tools.TwitterConfigFactory;
import com.russ4stall.critter.utils.CritterProperties;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import java.util.Map;

/**
 * Redirects users to twitter to authorize Critter.
 *
 * @author Russ Forstall
 */
@Result(name="input", location = "${authorizationURL}", type = "redirect")
public class RequestTwitterAuthorizationAction extends ActionSupport implements SessionAware {
    private String authorizationURL;
    private String groupId;

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

        TwitterFactory tf = new TwitterFactory(TwitterConfigFactory.getConfig());
        Twitter twitter = tf.getInstance();

        RequestToken requestToken;
        try {
            requestToken = twitter.getOAuthRequestToken(
                    CritterProperties.APPLICATION_HOST_NAME +
                            "/authorize-twitter?groupId=" +
                            groupId
            );
        } catch (Exception e) {
            e.printStackTrace();
            //return "error";
            throw e;
        }

        session.put("requestToken", requestToken);
        authorizationURL = requestToken.getAuthorizationURL();

        return INPUT;
    }

    public String getAuthorizationURL() {
        return authorizationURL;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
