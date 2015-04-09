package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.core.VoteStatus;
import com.russ4stall.critter.db.CreetDao;
import com.russ4stall.critter.db.DbiFactory;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by russ on 1/30/15.
 */
public class UpvoteAction extends ActionSupport implements SessionAware {
    private String creetId;
    private VoteStatus voteStatus;
    private Map<String, Object> session;

    @Override
    public String execute() throws Exception {
        //if user has already upvoted this creet, then do nothing
        if (voteStatus == VoteStatus.UPVOTED) {
            return SUCCESS;
        }
        User user = (User) session.get("user");

        try (CreetDao creetDao = new DbiFactory().getDbi().open(CreetDao.class)) {
            //if user has already downvoted this creet, then remove downvote
            if (voteStatus == VoteStatus.DOWNVOTED) {
                creetDao.removeDownvote(creetId, user.getId());
            }
            //upvote
            creetDao.upvote(creetId, user.getId());
        }

        return SUCCESS;
    }

    public void setCreetId(String creetId) {
        this.creetId = creetId;
    }

    public void setVoteStatus(VoteStatus voteStatus) {
        this.voteStatus = voteStatus;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
