package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Creet;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by russ on 1/30/15.
 */
public class CreetMapper implements ResultSetMapper<Creet> {
    public Creet map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new Creet(r.getString("id"),
                r.getString("message"),
                r.getString("group_id"),
                r.getString("user_id"),
                r.getTimestamp("timestamp"),
                r.getBoolean("sent_to_twitter"),
                r.getInt("score")
        );
    }
}
