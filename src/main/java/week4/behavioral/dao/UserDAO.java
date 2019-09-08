package week4.behavioral.dao;

import java.util.Collection;

public interface UserDAO {
    Collection<Permission> findPermissionsForUser(String userId);

    User findUser(String userId);

    Collection<User> findUsersForPermission(Permission permission);
}
