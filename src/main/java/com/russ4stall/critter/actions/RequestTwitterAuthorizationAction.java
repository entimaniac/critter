package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
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

        Twitter twitter = TwitterFactory.getSingleton();
        RequestToken requestToken = null;
        try {
            requestToken = twitter.getOAuthRequestToken("http://rabidwolves.com/authorize-twitter?groupId=" + groupId);
            //requestToken = twitter.getOAuthRequestToken("http://russforstall.com:8989/authorize-twitter?groupId=" + groupId);
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
