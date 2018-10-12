package com.moonteam.project.service;

import java.util.List;

import com.moonteam.project.bean.FunSigninfo;
import com.moonteam.project.bean.FunSignlog;

public interface ISignLogService {

	public boolean insert(FunSignlog signlog);
	
	public List<FunSigninfo> selectByUserId(String uid);
	
	public List<FunSignlog> selectBySignId(String sid);
}
