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
public interface GroupDao extends AutoCloseable {
    @SqlUpdate("INSERT INTO Groupe (id, name, twitter_handle, description, threshold, owner) VALUES (:id, :name, :twitterHandle, :description, :threshold, :owner)")
    void createGroup(@Bind("id") String id,
                     @Bind("name") String name,
                     @Bind("twitterHandle") String twitterHandle,
                     @Bind("description") String description,
                     @Bind("threshold") int threshold,
                     @Bind("owner") String owner);

    @SqlUpdate("UPDATE Groupe SET name=:name, twitter_handle = :twitterHandle, description = :description, threshold = :threshold owner WHERE id = :id")
    void updateGroup(@Bind("id") String id,
                     @Bind("name") String name,
                     @Bind("twitterHandle") String twitterHandle,
                     @Bind("description") String description,
                     @Bind("threshold") int threshold);

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
    @SqlUpdate("INSERT INTO UserGroupe (user_id, group_id) VALUES (:userId, :groupId)")
    void joinGroup(@Bind("userId") String userId, @Bind("groupId") String groupId);


    @SqlQuery("SELECT * FROM Groupe WHERE name LIKE :searchTerm")
    List<Group> searchForGroupsByName(@Bind("searchTerm") String searchTerm);

    @SqlUpdate("DELETE FROM Groupe WHERE id = :id")
    void deleteGroup(@Bind("id") String id);

    @SqlUpdate("DELETE FROM UserGroupe WHERE group_id = :group_id")
    void deleteUserGroup( @Bind("group_id") String group_id);

}
