package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.CreetAndVoteStatus;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetAndVoteStatusDao;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by russ on 1/29/15.
 */
public class GroupPageAction extends ActionSupport implements SessionAware {
    private String groupId;
    private Group group;
    private List<CreetAndVoteStatus> creets;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        group = groupDao.getGroupById(groupId);

        User user = (User) session.get("user");


        CreetAndVoteStatusDao creetAndVoteStatusDao = new DbiFactory().getDbi().open(CreetAndVoteStatusDao.class);
        creets = creetAndVoteStatusDao.getCreetsByGroup(groupId, user.getId());

        creetAndVoteStatusDao.close();
        groupDao.close();
        return INPUT;
    }


    public static void main(String[] args) {
        String id = UUID.randomUUID().toString();
        System.out.println(id);
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

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
