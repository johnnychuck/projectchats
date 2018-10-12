package com.moonteam.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moonteam.project.bean.FunSignlog;
import com.moonteam.project.bean.FunSignlogExample;

public interface FunSignlogMapper {
    int countByExample(FunSignlogExample example);

    int deleteByExample(FunSignlogExample example);

    int deleteByPrimaryKey(String id);

    int insert(FunSignlog record);

    int insertSelective(FunSignlog record);

    List<FunSignlog> selectByExample(FunSignlogExample example);

    FunSignlog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FunSignlog record, @Param("example") FunSignlogExample example);

    int updateByExample(@Param("record") FunSignlog record, @Param("example") FunSignlogExample example);

    int updateByPrimaryKeySelective(FunSignlog record);

    int updateByPrimaryKey(FunSignlog record);
}