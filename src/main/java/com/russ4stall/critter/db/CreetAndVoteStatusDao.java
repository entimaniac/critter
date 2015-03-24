package com.russ4stall.critter.db;

import com.russ4stall.critter.core.CreetAndVoteStatus;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by russ on 3/24/15.
 */
@RegisterMapper(CreetAndVoteStatusMapper.class)
public interface CreetAndVoteStatusDao {
    @SqlQuery("SELECT c.*, \n" +
            "(COALESCE((SELECT count(*) FROM Upvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY c.id),0) -\n" +
            "COALESCE((SELECT count(*) FROM Downvote \n" +
            "WHERE creet_id = c.id\n" +
            "GROUP BY c.id),0)\n" +
            ") as score, u.name, u.email, u.password, \n" +
            "(SELECT count(*) FROM Upvote WHERE user_id = :userId AND creet_id = c.id) as upvote, \n" +
            "(SELECT count(*) FROM Downvote WHERE user_id = :userId AND creet_id = c.id) as downvote \n" +
            "FROM Creet c \n" +
            "JOIN User u ON c.user_id = u.id\n" +
            "WHERE group_id = :groupId\n" +
            "ORDER BY timestamp DESC;")
    List<CreetAndVoteStatus> getCreetsByGroup(@Bind("groupId") String groupId, @Bind("userId") String userId);



    @SqlQuery("SELECT c.*,\n" +
            "    (COALESCE((SELECT count(*) FROM Upvote\n" +
            "    WHERE creet_id = c.id\n" +
            "    GROUP BY c.id),0) -\n" +
            "    COALESCE((SELECT count(*) FROM Downvote\n" +
            "    WHERE creet_id = c.id\n" +
            "    GROUP BY c.id),0)\n" +
            "            ) as score, u.name, u.email, u.password, \n" +
            "(SELECT count(*) FROM Upvote WHERE user_id = :userId AND creet_id = c.id) as upvote, \n" +
            "(SELECT count(*) FROM Downvote WHERE user_id = :userId AND creet_id = c.id) as downvote \n" +
            "    FROM Creet c\n" +
            "    JOIN User u ON c.user_id = u.id\n" +
            "    JOIN UserGroupe ug ON c.group_id = ug.group_id\n" +
            "    WHERE ug.user_id = :userId\n" +
            "    ORDER BY timestamp DESC;")
    List<CreetAndVoteStatus> getCreetsForAllGroupsByUser(@Bind("userId") String userId);

    void close();
}
