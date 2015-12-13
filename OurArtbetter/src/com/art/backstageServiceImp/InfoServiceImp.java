package com.art.backstageServiceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.backstageService.InfoService;
import com.art.dao.DateAndPosDao;
import com.art.entity.Information;

@Service
public class InfoServiceImp implements InfoService
{
	@Resource
	private DateAndPosDao dateAndPosDao;
	
	public void DateAndPosDao( DateAndPosDao dateAndPosDao)
	{
		this.dateAndPosDao = dateAndPosDao;
	}
	
	
	@Override
	public Information getTodayInfoByColumnId(int infoColumnId) {
	
		return dateAndPosDao.getTodayInfoByInfoColumnId(infoColumnId);
	}

	
}