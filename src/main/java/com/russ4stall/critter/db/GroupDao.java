package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Group;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by russ on 1/21/15.
 */
@RegisterMapper(GroupMapper.class)
public interface GroupDao {
    @SqlUpdate("insert into Groupe (id, name, twitter_handle, owner) values (:id, :name, :twitterHandle, :owner)")
    void createGroup(@Bind("id") String id, @Bind("name") String name, @Bind("twitterHandle") String twitterHandle, @Bind("owner") String owner);

    @SqlQuery("SELECT * FROM Groupe")
    List<Group> getAllGroups();

    @SqlQuery("SELECT * FROM Groupe WHERE name = :name")
    Group getGroupByName(@Bind("name") String name);

    @SqlQuery("SELECT * FROM Groupe WHERE id = :id")
    Group getGroupById(@Bind("id") String id);

    @SqlQuery("SELECT * FROM Groupe g\n" +
            "JOIN UserGroupe ug ON g.id = ug.group_id\n" +
            "WHERE ug.user_id = :userId\n" +
            ";")
    List<Group> getUserGroups(@Bind("userId") String userId);

    /**
     * Creates a relationship between a user and a group
     * in the UserGroupe table.
     *
     * @param userId
     * @param groupId
     */
    @SqlUpdate("insert into UserGroupe (user_id, group_id) values (:userId, :groupId)")
    void joinGroup(@Bind("userId") String userId, @Bind("groupId") String groupId);


    @SqlQuery("SELECT * FROM Groupe WHERE name LIKE :searchTerm")
    List<Group> searchForGroupsByName(@Bind("searchTerm") String searchTerm);




    void close();
}
