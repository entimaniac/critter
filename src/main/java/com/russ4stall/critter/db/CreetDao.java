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
public interface CreetDao extends AutoCloseable {

    @SqlUpdate("insert into Creet (id, message, group_id, user_id) values (:id, :message, :groupId, :userId)")
    void createCreet(@Bind("id") String id, @Bind("message") String message, @Bind("groupId") String groupId, @Bind("userId") String userId);

    @SqlQuery("SELECT c.*, \n" +
            "(COALESCE((SELECT count(*) FROM Upvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY c.id),0) -\n" +
            "COALESCE((SELECT count(*) FROM Downvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY c.id),0)\n" +
            ") as score, u.name, u.email, u.password\n" +
            "FROM Creet c \n" +
            "JOIN User u ON c.user_id = u.id\n" +
            "WHERE group_id = :groupId\n" +
            "ORDER BY timestamp DESC;")
    List<Creet> getCreetsByGroup(@Bind("groupId") String groupId);



    @SqlQuery("SELECT c.*,\n" +
            "    (COALESCE((SELECT count(*) FROM Upvote\n" +
            "    WHERE creet_id = c.id\n" +
            "    GROUP BY c.id),0) -\n" +
            "    COALESCE((SELECT count(*) FROM Downvote\n" +
            "    WHERE creet_id = c.id\n" +
            "    GROUP BY c.id),0)\n" +
            "            ) as score, u.name, u.email, u.password\n" +
            "    FROM Creet c\n" +
            "    JOIN User u ON c.user_id = u.id\n" +
            "    JOIN UserGroupe ug ON c.group_id = ug.group_id\n" +
            "    WHERE ug.user_id = :userId\n" +
            "    ORDER BY timestamp DESC;")
    List<Creet> getCreetsForAllGroupsByUser(@Bind("userId") String userId);



    @SqlQuery("SELECT c.*, u.name, u.email, u.password FROM Creet c JOIN User u ON u.id = c.user_id WHERE user_id = :userId")
    List<Creet> getCreetsByAuthor(@Bind("groupId") String userId);

    @SqlUpdate("INSERT INTO Upvote (creet_id, user_id) values (:creetId, :userId)")
    void upvote(@Bind("creetId") String creetId, @Bind("userId") String userId);

    @SqlUpdate("DELETE FROM Upvote WHERE creet_id = :creetId AND user_id = :userId")
    void removeUpvote(@Bind("creetId") String creetId, @Bind("userId") String userId);

    @SqlUpdate("INSERT INTO Downvote (creet_id, user_id) values (:creetId, :userId)")
    void downvote(@Bind("creetId") String creetId, @Bind("userId") String userId);

    @SqlUpdate("DELETE FROM Downvote WHERE creet_id = :creetId AND user_id = :userId")
    void removeDownvote(@Bind("creetId") String creetId, @Bind("userId") String userId);

    @SqlUpdate("DELETE FROM Creet WHERE group_id = :group_id")
    void deleteCreetByGroupId(@Bind("group_id") String group_id);

}
