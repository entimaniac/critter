package com.russ4stall.critter.db;

import com.russ4stall.critter.core.GroupTwitterCredentials;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by russellf on 4/9/2015.
 */
public class GroupTwitterCredentialsMapper implements ResultSetMapper<GroupTwitterCredentials> {
    @Override
    public GroupTwitterCredentials map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new GroupTwitterCredentials(
                r.getString("id"),
                r.getString("screen_name"),
                r.getInt("user_id"),
                r.getString("token"),
                r.getString("token_secret")
        );
    }
}
