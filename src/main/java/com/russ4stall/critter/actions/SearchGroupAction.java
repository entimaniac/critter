package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;

import java.util.List;

/**
 * Created by russ on 1/28/15.
 */
public class SearchGroupAction extends ActionSupport {
    private String searchTerm;
    private List<Group> groups;

    @Override
    public String input() throws Exception {
        return INPUT;
    }

    @Override
    public void validate() {
        if(searchTerm.length() > 120){
            addFieldError("searchTerm","Try searching for a shorter group name.");
        }
    }

    @Override
    public String execute() throws Exception {
        try (GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class)) {
            //adding %'s because jdbi doesn't allow it in the definition
            groups = groupDao.searchForGroupsByName("%" + searchTerm + "%");
        }

        return SUCCESS;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
