package com.moonteam.project.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.ImGroup;
import com.moonteam.project.bean.ImGroupExample;
import com.moonteam.project.bean.ImGroupExample.Criteria;
import com.moonteam.project.bean.ImUser;
import com.moonteam.project.dao.ImGroupMapper;
import com.moonteam.project.dao.ImUserMapper;
import com.moonteam.project.service.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService{

	@Autowired
	private ImGroupMapper groupMapper;
	@Autowired
	private ImUserMapper userMapper;
	
	public ImGroup selectById(int id) {
		return groupMapper.selectByPrimaryKey(id);
	}

	public List<ImGroup> selectByCreateId(int cid) {
		ImGroupExample example = new ImGroupExample();
        Criteria criteria = example.createCriteria();
        criteria.andCreateuseridEqualTo(cid);
		return groupMapper.selectByExample(example);
	}

	public int insert(ImGroup group) {
		if(groupMapper.insertSelective(group)>0){
			return group.getGid();
		}
		return 0;
	}

	public boolean update(ImGroup group) {
		return groupMapper.updateByPrimaryKeySelective(group)>0;
	}

	public boolean delete(int id) {
		return groupMapper.deleteByPrimaryKey(id)>0;
	}

	public List<ImUser> selectGroupUsers(int gid) {
		List<ImUser> members = new ArrayList<ImUser>();
		String memberstr =groupMapper.selectByPrimaryKey(gid).getMembers();
		if(memberstr!=null&&!memberstr.equals("")){
			if(memberstr.indexOf(",")>-1){
				String[] memberids =memberstr.split(",");
				for(String member:memberids){
					int uid = Integer.parseInt(member);
					ImUser user =userMapper.selectByPrimaryKey(uid);
					if(user!=null){
						members.add(user);
					}
				}
			}else{
				int uid = Integer.parseInt(memberstr);
				ImUser user =userMapper.selectByPrimaryKey(uid);
				if(user!=null){
					members.add(user);
				}
			}
			
		}
		return members;
	}

	public List<ImGroup> selectByUserId(int id) {
		List<ImGroup> groups = new ArrayList<ImGroup>();
		String groupstr =userMapper.selectByPrimaryKey(id).getGroups();
		if(groupstr!=null&&!groupstr.equals("")){
			if(groupstr.indexOf(",")>-1){
				String[] groupids =groupstr.split(",");
				for(String groupid:groupids){
					int gid = Integer.parseInt(groupid);
					ImGroup group =groupMapper.selectByPrimaryKey(gid);
					if(group!=null){
						groups.add(group);
					}
				}
			}else{
				int gid = Integer.parseInt(groupstr);
				ImGroup group =groupMapper.selectByPrimaryKey(gid);
				if(group!=null){
					groups.add(group);
				}
			}
			
		}
		return groups;
	}
	
	public ImGroup addGroupMember(int groupid, List<String> idList) {
		ImGroup group =groupMapper.selectByPrimaryKey(groupid);
		List<String> userids = Arrays.asList(group.getMembers().split(","));
		idList.removeAll(userids);
		String ids = getListString(idList, ",");
		if(StringUtils.isNotBlank(ids)){
			if(StringUtils.isNotBlank(group.getMembers())){
				group.setMembers(group.getMembers()+","+ids);
			}else{
				group.setMembers(ids);
			}
			groupMapper.updateByPrimaryKey(group);
		}
		return group;
	}
	
	private String getListString(List<String> idList,String splitStr){
		String result = "";
		if(idList!=null&&idList.size()>0){
			for(String idtemp:idList){
				if(StringUtils.isBlank(splitStr))splitStr=",";//默认分隔符
				result+=idtemp+splitStr;
			}
			if(result.lastIndexOf(splitStr)>-1)result=result.substring(0,result.lastIndexOf(splitStr));
		}
		return result;
		
	}

}
