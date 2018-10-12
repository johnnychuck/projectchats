package com.moonteam.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.ImUser;
import com.moonteam.project.bean.ImUserExample;
import com.moonteam.project.dao.ImUserMapper;
import com.moonteam.project.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
    private ImUserMapper userMapper;
	
	public ImUser selectByTell(String tell) {
		ImUserExample example =new ImUserExample();
		example.createCriteria().andCellphoneEqualTo(tell);
		return userMapper.selectByExample(example).get(0);
		
	}
    public int insert(ImUser user) {
    	if(userMapper.insertAndGetId(user)>0){
    		return user.getId();
    	}
        return 0;
    }
    public ImUser selectById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
    public List<ImUser> selectAll() {
		return userMapper.selectByExample(null);
	}
    public boolean update(ImUser user) {
        return userMapper.updateByPrimaryKeySelective(user)>0;
    }
	public ImUser login(String cellphone , String password) {
		ImUserExample example =new ImUserExample();
		example.createCriteria().andCellphoneEqualTo(cellphone);
		example.createCriteria().andPasswordEqualTo(password);
		List<ImUser> user =userMapper.selectByExample(example);
		if(user.size()>0){
			return user.get(0);
		}
		return null;
	}
	public boolean delete(int id) {
		return userMapper.deleteByPrimaryKey(id)>0;
	}
	public List<ImUser> selectFriends(int id) {
		ImUser user = userMapper.selectByPrimaryKey(id);
		List<ImUser> users = new ArrayList<ImUser>();
		String friends = user.getFriends();
		if(friends!=null&&friends!=""){
			if(friends.indexOf(",")>-1){
				String[] uids =friends.split(",");
				for(String uid:uids){
					users.add(userMapper.selectByPrimaryKey(Integer.parseInt(uid)));
				}
			}else{
				users.add(userMapper.selectByPrimaryKey(Integer.parseInt(friends)));
			}
		}
		return users;
	}
	
	public ImUser selectByCellphone(String cellphone){
		return userMapper.selectByCellphone(cellphone);
	}
}
