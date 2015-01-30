package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Group;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by russ on 1/21/15.
 */
public class GroupMapper implements ResultSetMapper<Group> {
    public Group map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new Group(r.getString("id"),
                r.getString("name"),
                r.getString("twitter_handle"),
                r.getString("owner")
        );
    }
}
