package com.myapp.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.myapp.model.User;

public class UserDao {
    Map<String, User> users = new HashMap<String, User>() {
	{
	    put("Jack", new User("John", "Jack", 2000));
	    put("Bob", new User("Bob", "Dilan", 3000));
	    put("Alicia", new User("Alicia", "Keys", 4000));
	}
    };

    
    
    public User findUser(String id) {
	return users.get(id);
    }

    public Map<String, User> findAllMap() {
	return users;
    }

    public Collection<User> findAllList() {
	return users.values();
    }

    public void addUser(User user) {
	users.put(user.getFirstName(), user);
    }
}
