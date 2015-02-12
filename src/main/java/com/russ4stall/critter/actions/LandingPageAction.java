package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetDao;
import com.russ4stall.critter.db.DbiFactory;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Date: 10/15/14
 * Time: 2:35 PM
 *
 * @author Russ Forstall
 */

public class LandingPageAction extends ActionSupport implements SessionAware {
    private List<Creet> creets;

    Map<String, Object> session;

    public String input() {
        CreetDao creetDao = new DbiFactory().getDbi().open(CreetDao.class);

        User user = (User) session.get("user");

        creets = creetDao.getCreetsForAllGroupsByUser(user.getId());

        return INPUT;
    }

    public List<Creet> getCreets() {
        return creets;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
