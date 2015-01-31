package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Creet;
import com.russ4stall.critter.core.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by russ on 1/30/15.
 */
public class CreetMapper implements ResultSetMapper<Creet> {
    public Creet map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        User user = new User(r.getString("name"), r.getString("email"), r.getString("password"));
        return new Creet(r.getString("id"),
                r.getString("message"),
                r.getString("group_id"),
                user,
                r.getTimestamp("timestamp"),
                r.getBoolean("sent_to_twitter"),
                r.getInt("score")
        );
    }
}
