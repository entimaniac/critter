package com.russ4stall.critter.db;


import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.CreetAndVoteStatus;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.core.VoteStatus;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by russ on 3/24/15.
 */
public class CreetAndVoteStatusMapper implements ResultSetMapper<CreetAndVoteStatus> {
    public CreetAndVoteStatus map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        User user = new User(r.getString("user_id"),r.getString("name"), r.getString("email"), r.getString("password"));
        Creet creet = new Creet(r.getString("id"),
                r.getString("message"),
                r.getString("group_id"),
                user,
                r.getTimestamp("timestamp"),
                r.getBoolean("sent_to_twitter"),
                r.getInt("score")
        );
        VoteStatus voteStatus = VoteStatus.NONE;
        if (r.getBoolean("upvote")) {
            voteStatus = VoteStatus.UPVOTED;
        } else if (r.getBoolean("downvote")) {
            voteStatus = VoteStatus.DOWNVOTED;
        }
        return new CreetAndVoteStatus(creet, voteStatus);
    }
}
