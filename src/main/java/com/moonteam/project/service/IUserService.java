package com.moonteam.project.service;

import java.util.List;

import com.moonteam.project.bean.ImUser;

public interface IUserService {
	
	public ImUser login(String cellphone,String password);
    
    public ImUser selectByTell(String tell);
	
	public ImUser selectById(int id);
	
	public List<ImUser> selectFriends(int id);
    
	public List<ImUser> selectAll();
    
    public int insert(ImUser user);

    public boolean update(ImUser user);
    
    public boolean delete(int id);
    
    public ImUser selectByCellphone(String cellphone);
    
}
