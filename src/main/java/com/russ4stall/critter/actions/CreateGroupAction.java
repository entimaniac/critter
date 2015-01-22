package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.GroupDao;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by russ on 1/15/15.
 */
@Result(location = "/landing-page", type = "redirect")
public class CreateGroupAction extends ActionSupport implements SessionAware {
    private String name;
    private String twitterHandle;

    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        return INPUT;
    }

    @Override
    public void validate() {
        super.validate();
    }

    @Override
    public String execute() throws Exception {
        GroupDao groupDao = new DbiFactory().getDbi().open(GroupDao.class);
        groupDao.insert(name, twitterHandle, ((User) session.get("user")).getId());

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

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
