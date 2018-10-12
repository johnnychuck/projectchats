package com.moonteam.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.FunComment;
import com.moonteam.project.bean.FunCommentExample;
import com.moonteam.project.dao.FunCommentMapper;
import com.moonteam.project.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService{

	@Autowired
	private FunCommentMapper commentMapper;
	
	
	public boolean insert(FunComment comment) {
		return commentMapper.insertSelective(comment)>0;
	}

	public List<FunComment> selectByDynamicId(String did) {
		FunCommentExample example = new FunCommentExample();
		example.createCriteria().andDynamicidEqualTo(did);
		example.setOrderByClause(" createtime asc");
		return commentMapper.selectByExample(example);
	}

}
