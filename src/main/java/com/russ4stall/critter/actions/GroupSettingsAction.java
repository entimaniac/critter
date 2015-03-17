package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAllLowerCase;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Created by russellf on 3/17/2015.
 */
public class GroupSettingsAction extends ActionSupport {
    private String name;
    private String twitterHandle;
    private String description;
    private int threshold;
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

        if (threshold < 0) {
            addFieldError("threshold", "Can't be a negative number!");
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

        Group group = groupDao.getGroupById(groupId);
        User user = (User) session.get("user");
        //verify user has permission to update group
        if(!user.getId().equals(group.getOwner())) {
            return "error";
        }

        groupDao.updateGroup(groupId, name, twitterHandle, description, threshold);


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

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
