package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.CreetAndVoteStatus;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.CreetAndVoteStatusDao;
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
    private List<CreetAndVoteStatus> creets;
    Map<String, Object> session;

    public String input() throws Exception {
        User user = (User) session.get("user");

        try (CreetAndVoteStatusDao creetAndVoteStatusDao = new DbiFactory().getDbi().open(CreetAndVoteStatusDao.class)) {
            creets = creetAndVoteStatusDao.getCreetsForAllGroupsByUser(user.getId());
        }

        return INPUT;
    }

    public List<CreetAndVoteStatus> getCreets() {
        return creets;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
