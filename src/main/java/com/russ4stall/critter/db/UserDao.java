package com.russ4stall.critter.db;

import com.russ4stall.critter.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Date: 10/15/14
 * Time: 11:45 AM
 *
 * @author Russ Forstall
 */
@RegisterMapper(UserMapper.class)
public interface UserDao extends AutoCloseable {
    @SqlUpdate("insert into User (id, name, email, password) values (:id, :name, :email, :password);")
    void createUser(@Bind("id") String id, @Bind("name") String name, @Bind("email") String email, @Bind("password") String password);

    @SqlQuery("SELECT * FROM User WHERE email = :email;")
    User getUserByEmail(@Bind("email") String email);

    @SqlQuery("SELECT * FROM User WHERE id = :userId;")
    User getUserById(@Bind("userId") String userId);

    @SqlQuery("SELECT count(*) FROM UserGroupe WHERE user_id = :userId AND group_id = :groupId;")
    boolean isUserGroupMember(@Bind("userId") String userId, @Bind("groupId") String groupId);

    @SqlUpdate("UPDATE User SET password = :password WHERE id = :userId")
    void changePassword(@Bind("userId") String userId, @Bind("password") String password);
}
