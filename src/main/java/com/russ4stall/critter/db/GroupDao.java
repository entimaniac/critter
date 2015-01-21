package com.russ4stall.critter.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by russ on 1/21/15.
 */
@RegisterMapper(GroupMapper.class)
public interface GroupDao {
    @SqlUpdate("insert into Group (name, twitterHandle, owner) values (:name, :twitterHandle, :owner)")
    @GetGeneratedKeys
    int insert(@Bind("name") String name, @Bind("twitterHandle") String twitterHandle, @Bind("owner") int owner);
}
