package com.moonteam.project.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moonteam.project.bean.VerifyCode;
import com.moonteam.project.dao.VerifyCodeMapper;
import com.moonteam.project.service.VerifyCodeService;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

	@Autowired
	private VerifyCodeMapper verifyCodeMapper;
	
	public int insertSelective(VerifyCode verifyCode) {
		return verifyCodeMapper.insertSelective(verifyCode);
	}

	public VerifyCode selectLastestByCellPhone(String cellphone) {
		return verifyCodeMapper.selectLastestByCellPhone(cellphone);
	}

	public int deleteByPrimaryKey(Long id) {
		return verifyCodeMapper.deleteByPrimaryKey(id);
	}

	public VerifyCode selectById(Long id) {
		return verifyCodeMapper.selectByPrimaryKey(id);
	}
	
	public boolean checkAndFreshCode(String cellphone,String vcode){
		VerifyCode verifyCode = verifyCodeMapper.selectLastestByCellPhone(cellphone);
		if(verifyCode==null||verifyCode.getCreateTime().getTime()+60000L<System.currentTimeMillis()){//是否超过60秒
			VerifyCode nvcode = new VerifyCode();
			nvcode.setCellphone(cellphone);
			nvcode.setCreateTime(new Date());
			nvcode.setVcode(vcode);
			verifyCodeMapper.insertSelective(nvcode);
			return true;
		}else{
			return false;
		}
	}

}
