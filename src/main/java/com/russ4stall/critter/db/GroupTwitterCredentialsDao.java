package com.russ4stall.critter.db;

import com.russ4stall.critter.core.GroupTwitterCredentials;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by russellf on 4/9/2015.
 */
public interface GroupTwitterCredentialsDao extends AutoCloseable {

    @SqlUpdate("INSERT INTO GroupTwitterCredentials (group_id, token, token_secret) VALUES (:groupId, :token, :tokenSecret);")
    void createGroupTwitterCredentials(@Bind("groupId") String groupId,
                               @Bind("token") String token,
                               @Bind("tokenSecret") String tokenSecret);

    @SqlQuery("SELECT * FROM GroupTwitterCredentials WHERE group_id = :groupId")
    GroupTwitterCredentials getGroupTwitterCredentials(@Bind("groupId") String groupId);
}
