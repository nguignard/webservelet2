package com.myapp.dao;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.myapp.model.Login;

public class LoginDao {
    Map<String, Login> logins = new HashMap<String, Login>() {
	{
	    put("Jack@gmail", new Login("Jack@gmail", "Jack"));
	    put("Bob@gmail", new Login("Bob@gmail", "Dilan"));
	    put("Alicia@gmail", new Login("Alicia@gmail", "Keys"));
	}
    };

    public Login findbyId(String id) {
	return logins.get(id);
    }

    public Map<String, Login> findAllMap() {
	return logins;
    }

    public Collection<Login> findAllList() {
	return logins.values();
    }

    public void addLogin(Login Login) {
	logins.put(Login.getLogin(), Login);
    }
}
