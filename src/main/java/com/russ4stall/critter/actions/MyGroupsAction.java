package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by russ on 2/3/15.
 */
public class MyGroupsAction extends ActionSupport implements SessionAware {
    private List<Group> userGroups;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        User user = (User) session.get("user");
        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            userGroups = groupDao.getUserGroups(user.getId());
        }

        return INPUT;
    }

    public List<Group> getUserGroups() {
        return userGroups;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
