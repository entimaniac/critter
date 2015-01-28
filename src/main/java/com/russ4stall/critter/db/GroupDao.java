package com.russ4stall.critter.db;

import com.russ4stall.critter.core.Group;
import com.russ4stall.critter.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by russ on 1/21/15.
 */
@RegisterMapper(GroupMapper.class)
public interface GroupDao {
    @SqlUpdate("insert into Groupe (name, twitter_handle, owner) values (:name, :twitterHandle, :owner)")
    @GetGeneratedKeys
    int insert(@Bind("name") String name, @Bind("twitterHandle") String twitterHandle, @Bind("owner") int owner);

    @SqlQuery("SELECT * FROM Groupe")
    List<Group> getAllGroups();

    @SqlQuery("SELECT * FROM Groupe WHERE name LIKE :searchTerm")
    List<Group> searchForGroupsByName(@Bind("searchTerm") String searchTerm);

    @SqlQuery("SELECT * FROM Groupe WHERE name = :name")
    Group getGroupByName(@Bind("name") String name);

    void close();
}
