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
@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class CreateGroupAction extends ActionSupport implements SessionAware {
    private String name;
    private String twitterHandle;
    private String description;

    private String groupId;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        return INPUT;
    }


    @Override
    public void validate() {
        if (isEmpty(name)) {
            addFieldError("name", "Don't leave name blank dummy!");
            return;
        }

        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);

        if (groupDao.getGroupByName(name) != null) {
            addFieldError("name", "Already exists poser!");
            return;
        }
        groupDao.close();
    }

    @Override
    public String execute() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);

        User user = (User) session.get("user");
        groupId = UUID.randomUUID().toString();
        Group group = new Group(groupId, name, twitterHandle, description, user.getId());
        groupDao.createGroup(group.getId(), name, twitterHandle, description, user.getId());

        //automatically join the group creator to the group
        groupDao.joinGroup(user.getId(), group.getId());

        groupDao.close();
        return SUCCESS;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
