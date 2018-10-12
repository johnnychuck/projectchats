package com.moonteam.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moonteam.project.bean.ImGroup;
import com.moonteam.project.bean.ImGroupExample;

public interface ImGroupMapper {
    int countByExample(ImGroupExample example);

    int deleteByExample(ImGroupExample example);

    int deleteByPrimaryKey(Integer gid);

    int insert(ImGroup record);

    int insertSelective(ImGroup record);

    List<ImGroup> selectByExample(ImGroupExample example);

    ImGroup selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") ImGroup record, @Param("example") ImGroupExample example);

    int updateByExample(@Param("record") ImGroup record, @Param("example") ImGroupExample example);

    int updateByPrimaryKeySelective(ImGroup record);

    int updateByPrimaryKey(ImGroup record);
}