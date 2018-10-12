package com.moonteam.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.FunSigninfo;
import com.moonteam.project.bean.FunSigninfoExample;
import com.moonteam.project.dao.FunSigninfoMapper;
import com.moonteam.project.service.ISignInfoService;

@Service
public class SignInfoServiceImpl implements ISignInfoService{

	@Autowired
	private FunSigninfoMapper signinfoMapper;
	
	public boolean insert(FunSigninfo signinfo) {
		return signinfoMapper.insertSelective(signinfo)>0;
	}

	public boolean delete(String id) {
		return signinfoMapper.deleteByPrimaryKey(id)>0;
	}

	public List<FunSigninfo> selectByCreateId(String uid) {
		FunSigninfoExample example = new FunSigninfoExample();
		example.createCriteria().andCreateuseridEqualTo(uid);
		example.setOrderByClause(" createtime desc");
		return signinfoMapper.selectByExample(example);
	}

	public FunSigninfo selectById(String sid) {
		return signinfoMapper.selectByPrimaryKey(sid);
	}

}
