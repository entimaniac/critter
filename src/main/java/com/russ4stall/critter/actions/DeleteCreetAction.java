package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import org.apache.struts2.convention.annotation.Result;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.CreetDao;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


/**
 * @author j.connal.sumlin on 4/8/2015.
 */
public class DeleteCreetAction extends ActionSupport implements SessionAware{
    private String creetId;
    private Map<String, Object> session;


    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        try (CreetDao creetDao = new DbiFactory().getDbi().open(CreetDao.class)){
            if(!creetDao.getCreetAuthorById(creetId).equals(user.getId())) {
                return "accessDenied";
            }
            creetDao.deleteCreet(creetId, user.getId());
        }
        return SUCCESS;
    }


    public String getCreetId() { return creetId; }

    public void setCreetId(String creetId) { this.creetId = creetId; }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
