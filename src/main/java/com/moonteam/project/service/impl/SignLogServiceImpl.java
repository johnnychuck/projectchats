package com.moonteam.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.FunSigninfo;
import com.moonteam.project.bean.FunSignlog;
import com.moonteam.project.bean.FunSignlogExample;
import com.moonteam.project.dao.FunSigninfoMapper;
import com.moonteam.project.dao.FunSignlogMapper;
import com.moonteam.project.service.ISignLogService;

@Service
public class SignLogServiceImpl implements ISignLogService{

	@Autowired
	private FunSignlogMapper signlogMapper;
	@Autowired
	private FunSigninfoMapper signinfoMapper;
	
	public boolean insert(FunSignlog signlog) {
		return signlogMapper.insertSelective(signlog)>0;
	}

	public List<FunSigninfo> selectByUserId(String uid) {
		FunSignlogExample example = new FunSignlogExample();
		example.createCriteria().andSignuseridEqualTo(uid);
		List<FunSignlog> signlogs =signlogMapper.selectByExample(example);
		List<FunSigninfo> signinfos = new ArrayList<FunSigninfo>();
		if(signlogs.size()>0){
			for(FunSignlog log:signlogs){
				FunSigninfo signinfo = signinfoMapper.selectByPrimaryKey(log.getSignid());
				signinfos.add(signinfo);
			}
		}
		return signinfos;
	}

	public List<FunSignlog> selectBySignId(String sid) {
		FunSignlogExample example = new FunSignlogExample();
		example.createCriteria().andSignidEqualTo(sid);
		return signlogMapper.selectByExample(example);
	}

}
