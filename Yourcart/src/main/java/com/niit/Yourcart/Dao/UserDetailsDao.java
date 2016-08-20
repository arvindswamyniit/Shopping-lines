package com.niit.Yourcart.Dao;

import java.util.List;

import com.niit.Yourcart.model.UserDetails;

public interface UserDetailsDao {
	public boolean save(UserDetails userDetails);
	public boolean update(UserDetails userDetails);
	public boolean delete(UserDetails userDetails);
	public UserDetails get(String id);
    public List<UserDetails> list();


}
