package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetDao;
import com.russ4stall.critter.db.DbiFactory;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by russ on 1/30/15.
 */
public class DownvoteAction extends ActionSupport implements SessionAware {
    private String creetId;

    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        CreetDao creetDao = new DbiFactory().getDbi().open(CreetDao.class);
        User user = (User) session.get("user");
        creetDao.downvote(creetId, user.getId());

        return SUCCESS;
    }

    public void setCreetId(String creetId) {
        this.creetId = creetId;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}