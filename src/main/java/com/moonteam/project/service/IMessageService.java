package com.moonteam.project.service;

import java.util.List;

import com.moonteam.project.bean.ImMessage;

public interface IMessageService {
	
	public boolean insert(ImMessage message);
	
	public boolean delete(String id);
	
	public ImMessage selectById(String id);
	
	public List<ImMessage> selectOfflineLogs(int uid);

}
