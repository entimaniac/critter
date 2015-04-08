package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.CreetAndVoteStatus;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetAndVoteStatusDao;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import com.russ4stall.critter.db.UserDao;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by russ on 1/29/15.
 */
public class GroupPageAction extends ActionSupport implements SessionAware {
    private String groupId;
    private Group group;
    private List<CreetAndVoteStatus> creets;
    private boolean groupMember;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        User user = (User) session.get("user");

        try (UserDao userDao = new DbiFactory().getDbi().open(UserDao.class)) {
            groupMember = userDao.isUserGroupMember(user.getId(), groupId);
        }

        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            group = groupDao.getGroupById(groupId);
        }

        //if user isn't in group -> return
        if (!groupMember) {
            return INPUT;
        }

        try (CreetAndVoteStatusDao creetAndVoteStatusDao = new DbiFactory().getDbi().open(CreetAndVoteStatusDao.class)) {
            creets = creetAndVoteStatusDao.getCreetsByGroup(groupId, user.getId());
        }

        return INPUT;
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

    public List<CreetAndVoteStatus> getCreets() {
        return creets;
    }

    public boolean isGroupMember() {
        return groupMember;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
