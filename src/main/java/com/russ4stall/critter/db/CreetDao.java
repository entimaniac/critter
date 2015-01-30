package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Creet;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by russ on 1/30/15.
 */
@RegisterMapper(CreetMapper.class)
public interface CreetDao {

    @SqlUpdate("insert into Creet (id, message, group_id, user_id) values (:id, :message, :groupId, :userId)")
    void createCreet(@Bind("id") String id, @Bind("message") String message, @Bind("groupId") String groupId, @Bind("userId") String userId);

    @SqlQuery("SELECT *, \n" +
            "(COALESCE((SELECT count(*) FROM Upvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY id),0) -\n" +
            "COALESCE((SELECT count(*) FROM Downvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY id),0)\n" +
            ") as score\n" +
            "FROM Creet c \n" +
            "WHERE group_id = :groupId\n" +
            ";")
    List<Creet> getCreetsByGroup(@Bind("groupId") String groupId);

    @SqlQuery("SELECT * FROM Creet WHERE user_id = :userId")
    List<Creet> getCreetsByAuthor(@Bind("groupId") String userId);

    void close();
}
