package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.uncapitalize;

/**
 * Created by russ on 1/27/15.
 */
@Result(location = "/my-groups", type = "redirect")
public class DeleteGroupAction extends ActionSupport implements SessionAware {
    private String groupId;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        User user = (User) session.get("user");

        try {
            if (!groupDao.getGroupById(groupId).getOwner().equals(user.getId())) {
                addFieldError("password", "You don't own this group!");
                return "error";
            }
        }catch(Exception e) {

        }
        return INPUT;
    }


    @Override
    public String execute() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        User user = (User) session.get("user");

        try {
            if (!groupDao.getGroupById(groupId).getOwner().equals(user.getId())) {
                addFieldError("password", "You don't own this group!");
                return "error";
            }
        }catch(Exception e) {

        }
        groupDao.deleteGroup(groupId);
        groupDao.deleteUserGroup(groupId);

        groupDao.close();
        return SUCCESS;

    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) { this.groupId = groupId;}

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
