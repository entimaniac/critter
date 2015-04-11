package com.russ4stall.critter.db;

import com.russ4stall.critter.core.GroupTwitterCredentials;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by russellf on 4/9/2015.
 */
@RegisterMapper(GroupTwitterCredentialsMapper.class)
public interface GroupTwitterCredentialsDao extends AutoCloseable {

    @SqlUpdate("INSERT INTO GroupTwitterCredentials (group_id, screen_name, user_id, token, token_secret) " +
            "VALUES (:groupId, :screenName, :userId, :token, :tokenSecret);")
    void createGroupTwitterCredentials(
            @Bind("groupId") String groupId,
            @Bind("screenName") String screenName,
            @Bind("userId") long userId,
            @Bind("token") String token,
            @Bind("tokenSecret") String tokenSecret
    );

    @SqlQuery("SELECT * FROM GroupTwitterCredentials WHERE group_id = :groupId")
    GroupTwitterCredentials getGroupTwitterCredentials(@Bind("groupId") String groupId);
}
