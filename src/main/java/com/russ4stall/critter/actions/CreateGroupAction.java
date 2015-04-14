package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Created by russ on 1/27/15.
 */
@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class CreateGroupAction extends ActionSupport implements SessionAware {
    private String name;
    private String twitterHandle;
    private String description;
    private int threshold;
    private boolean isEdit;
    private String groupId;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        if (isEdit) {
            GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
            Group group = groupDao.getGroupById(groupId);
            name = group.getName();
            twitterHandle = group.getTwitterHandle();
            description = group.getDescription();
            threshold = group.getThreshold();
        }
        return INPUT;
    }


    @Override
    public void validate() {
        if (isEmpty(name)) {
            addFieldError("name", "Don't leave name blank dummy!");
            return;
        }else if(name.length() > 45) {
            addFieldError("name","Woooooah, let's keep this on a two name basis");
            return;
        }

        if (threshold < 0) {
            addFieldError("threshold", "Can't be a negative number!");
            return;
        }

        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            if (groupDao.getGroupByName(name) != null) {
                addFieldError("name", "Already exists poser!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        groupId = UUID.randomUUID().toString();

        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            if (isEdit) {
                Group group = groupDao.getGroupById(groupId);
                //verify user has permission to update group
                if(!user.getId().equals(group.getOwner())) {
                    return "error";
                }

                groupDao.updateGroup(groupId, name, twitterHandle, description, threshold);

            } else {
                groupDao.createGroup(groupId, name, twitterHandle, description, threshold, user.getId());
                //automatically join the group creator to the group
                groupDao.joinGroup(user.getId(), groupId);
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

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
