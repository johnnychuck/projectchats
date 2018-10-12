package com.moonteam.project.service;

import java.util.List;

import com.moonteam.project.bean.FunComment;

public interface ICommentService {

	public boolean insert(FunComment comment);
	
	public List<FunComment> selectByDynamicId(String did);
	
}
