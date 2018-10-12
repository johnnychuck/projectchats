package com.moonteam.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moonteam.project.bean.FunComment;
import com.moonteam.project.bean.FunCommentExample;

public interface FunCommentMapper {
    int countByExample(FunCommentExample example);

    int deleteByExample(FunCommentExample example);

    int deleteByPrimaryKey(String id);

    int insert(FunComment record);

    int insertSelective(FunComment record);

    List<FunComment> selectByExample(FunCommentExample example);

    FunComment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FunComment record, @Param("example") FunCommentExample example);

    int updateByExample(@Param("record") FunComment record, @Param("example") FunCommentExample example);

    int updateByPrimaryKeySelective(FunComment record);

    int updateByPrimaryKey(FunComment record);
}