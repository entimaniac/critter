package com.russ4stall.critter.actions;

/**
 * Created by j.connal.sumlin on 4/17/2015.
 */

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import com.russ4stall.critter.db.GroupTwitterCredentialsDao;
import com.russ4stall.critter.db.UserDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class GroupSettingsAction extends ActionSupport implements SessionAware {
    private String name;
    private String twitterHandle;
    private String description;
    private int threshold;
    private String groupId;
    private Map<String, Object> session;
    private Group group;
    private boolean linkedToTwitter;
    private boolean groupMember;
    private boolean madeChanges;

    @Override
    public String input() throws Exception{
        User user = (User) session.get("user");

        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            group = groupDao.getGroupById(groupId);
            name = group.getName();
            twitterHandle = group.getTwitterHandle();
            description = group.getDescription();
            threshold = group.getThreshold();
        }


        try (UserDao userDao = new DbiFactory().getDbi().open(UserDao.class)) {
            groupMember = userDao.isUserGroupMember(user.getId(), groupId);
        }

        try (GroupTwitterCredentialsDao groupTwitterCredentialsDao =
                     new DbiFactory().getDbi().open(GroupTwitterCredentialsDao.class)) {
            linkedToTwitter = groupTwitterCredentialsDao.hasTwitterCredentials(groupId);
        }

        //if user isn't in group -> return
        if (!groupMember) {
            return INPUT;
        }


        return INPUT;
    }

    @Override
    public void validate() {
        if(madeChanges) {
            GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
            group = groupDao.getGroupById(groupId);

            if (isEmpty(name)) {
                name = group.getName();
                addFieldError("name", "You can't change to an blank name! Qué asco!");
                return;
            } else if (name.length() > 45) {
                addFieldError("name", "Woooooah, let's keep this on a two name basis");
                return;
            }
            if(isEmpty(twitterHandle)) {
                twitterHandle = group.getTwitterHandle();
            }

            if (threshold < 0) {
                threshold = group.getThreshold();
                addFieldError("threshold", "Can't be a negative number!");
            }

            if(isEmpty(description)){
                description = group.getDescription();
            }

            if (groupDao.getGroupByName(name) != null && !name.equals(group.getName())) {
                addFieldError("name", "Already exists poser!");
                return;
            }

        }
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        if(madeChanges) {
            try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
                Group group = groupDao.getGroupById(groupId);
                groupDao.updateGroup(groupId, name, twitterHandle, description, threshold);
            }
        }
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

    public Group getGroup() {
        return group;
    }

    public boolean isLinkedToTwitter() {
        return linkedToTwitter;
    }

    public boolean isGroupMember() {
        return groupMember;
    }

    public boolean getMadeChanges() {return this.madeChanges; }

    public void setMadeChanges(boolean madeChanges) { this.madeChanges = madeChanges; }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
