package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetDao;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by russ on 1/30/15.
 */
@Result(location = "/group-page", type = "redirect", params = {"groupId", "${groupId}"})
public class PostCreetAction extends ActionSupport implements SessionAware {
    private String groupId;
    private String message;
    private Creet creet;
    private List<Group> userGroups;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        User user = (User) session.get("user");
        userGroups = groupDao.getUserGroups(user.getId());

        return INPUT;
    }


    @Override
    public String execute() throws Exception {
        CreetDao creetDao = new DbiFactory().getDbi().open(CreetDao.class);

        User user = (User) session.get("user");

        creet = new Creet();
        creet.setId(UUID.randomUUID().toString());
        creet.setGroupId(groupId);
        creet.setMessage(message);
        creet.setAuthor(user);

        creetDao.createCreet(creet.getId(), message, groupId, user.getId());

        return SUCCESS;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public Creet getCreet() {
        return creet;
    }

    public List<Group> getUserGroups() {
        return userGroups;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
