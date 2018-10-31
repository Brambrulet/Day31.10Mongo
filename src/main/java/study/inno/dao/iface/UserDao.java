package study.inno.dao.iface;

import study.inno.pojo.User;

import java.util.Set;

public interface UserDao {
     Set<User> getAllUsers();

     User getByName(String name);

     void updateByName(User user);

     void deleteByName(User user);

     void add(User user);
}
