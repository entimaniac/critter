package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import com.russ4stall.critter.db.GroupTwitterCredentialsDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * This action currently only removes the twitter credentials from critters database.
 * In the future, it should remove authorization on twitters side.
 *
 * @author Russ Forstall
 */
@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class UnlinkTwitterAction extends ActionSupport implements SessionAware {
    private String groupId;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        User user = (User) session.get("user");
        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            if (!groupDao.getGroupById(groupId).getOwner().equals(user.getId())) {
                return "accessDenied";
            }
        }

        try (GroupTwitterCredentialsDao gtcDao = new DbiFactory().getDbi().open(GroupTwitterCredentialsDao.class)) {
            gtcDao.deleteTwitterCredentials(groupId);
        }

        return SUCCESS;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
