package com.moonteam.project.service;

import com.moonteam.project.bean.VerifyCode;

public interface VerifyCodeService {
	
	public int insertSelective(VerifyCode verifyCode);
	
	public VerifyCode selectLastestByCellPhone(String cellphone);
	
	public int deleteByPrimaryKey(Long id);
	
	public VerifyCode selectById(Long id);
	
	public boolean checkAndFreshCode(String cellphone,String vcode);
}
