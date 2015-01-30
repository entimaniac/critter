package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;

import java.util.List;
import java.util.UUID;

/**
 * Created by russ on 1/29/15.
 */
public class GroupPageAction extends ActionSupport {
    private String groupId;
    private Group group;
    private List<Creet> creets;

    @Override
    public String input() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        group = groupDao.getGroupById(groupId);

        //todo: get all creets associated with group

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

    public List<Creet> getCreets() {
        return creets;
    }
}
