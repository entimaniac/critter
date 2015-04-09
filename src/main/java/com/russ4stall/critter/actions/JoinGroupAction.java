package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


/**
 * Created by russ on 1/29/15.
 */
@Result(location = "/landing-page", type = "redirect")
public class JoinGroupAction extends ActionSupport implements SessionAware{
    private String groupId;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        User user = (User) session.get("user");
        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            groupDao.joinGroup(user.getId(), groupId);
        }

        return SUCCESS;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
