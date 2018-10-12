package com.moonteam.project.service;

import java.util.List;

import com.moonteam.project.bean.ImGroup;
import com.moonteam.project.bean.ImUser;

public interface IGroupService {
    
    public int insert(ImGroup group);
    
    public boolean delete(int id);
    
    public boolean update(ImGroup group);
    
    public ImGroup selectById(int id);
    
    public List<ImGroup> selectByCreateId(int id);
    
    public List<ImUser> selectGroupUsers(int gid);
    
    public List<ImGroup> selectByUserId(int id);
    
    public ImGroup addGroupMember(int groupid,List<String>idList);

}
