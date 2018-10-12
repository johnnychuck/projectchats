package com.moonteam.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moonteam.project.bean.FunSigninfo;
import com.moonteam.project.bean.FunSigninfoExample;

public interface FunSigninfoMapper {
    int countByExample(FunSigninfoExample example);

    int deleteByExample(FunSigninfoExample example);

    int deleteByPrimaryKey(String sid);

    int insert(FunSigninfo record);

    int insertSelective(FunSigninfo record);

    List<FunSigninfo> selectByExample(FunSigninfoExample example);

    FunSigninfo selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") FunSigninfo record, @Param("example") FunSigninfoExample example);

    int updateByExample(@Param("record") FunSigninfo record, @Param("example") FunSigninfoExample example);

    int updateByPrimaryKeySelective(FunSigninfo record);

    int updateByPrimaryKey(FunSigninfo record);
}