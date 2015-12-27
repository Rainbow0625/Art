package com.art.backstageServiceImp;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.backstageService.InfoService;
import com.art.dao.DateAndPosDao;
import com.art.dao.InfoColumnDao;
import com.art.dao.InformationDao;
import com.art.entity.DateAndPos;
import com.art.entity.InfoColumn;
import com.art.entity.Information;

@Service
@Transactional
public class InfoServiceImp implements InfoService
{
	@Autowired
	private DateAndPosDao dateAndPosDao;
	@Autowired
	private InformationDao informationDao;
	@Autowired
	private InfoColumnDao infoColumnDao;
	
	
	
	public InfoServiceImp( ){}
	
	public void setDateAndPosDao(DateAndPosDao dateAndPosDao){
		this.dateAndPosDao=dateAndPosDao;
	}
	
	public void setInformationDao(InformationDao informationDao){
		this.informationDao=informationDao;
	}
	
	public void setDateAndPosDao(InfoColumnDao infoColumnDao){
		this.infoColumnDao=infoColumnDao;
	}
	
	
	
	
	
	@Override
	public Information getTodayInfoByColumnId(int infoColumnId) {
	
		try {
			
			Information information =  dateAndPosDao.getTodayInfoByInfoColumnId(infoColumnId);
			return information;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
	}
	
	@Override
	public List<Information> getAllInfo()
	{
		return informationDao.getAllInfo();
		
	}


	@Override
	public List<Information> getAllAdver() {
		
		return informationDao.getAllAdver();
	}


	@Override
	public List<Information> getInformationByEditorId(int editorId) {

		return informationDao.getInformationByEditorId(editorId);
	}


	@Override
	public List<Information> getInformationByChiefEditorId(int chiefEditorId) {
		
		return informationDao.getInformationByChiefEditorId(chiefEditorId);
	}


	@Override
	public List<DateAndPos> getDateAndPosByInformationId(int informationId) {
		
		return dateAndPosDao.getDateAndPosByInformationId(informationId);
	}


	@Override
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId) {
		
		return dateAndPosDao.getDateAndPosByInfoColumnId(infoColumnId);
	}


	@Override
	public Information getInformationById(int informationId) {
		
		return informationDao.getInformationById(informationId);
	}


	@Override
	public InfoColumn getInfoColumnById(int infoColumnById) {
		
		return infoColumnDao.getInfoColumnById(infoColumnById);
	}


	@Override
	public double getInforColumnPriceById(int infoColumnById) {
		
		return infoColumnDao.getInforColumnPriceById(infoColumnById);
	}


	@Override
	public String getInforColumnTypeById(int infoColumnById) {
		
		return infoColumnDao.getInforColumnTypeById(infoColumnById);
	}


	@Override
	public List<Information> getAdverByEditorId(int editorId) {
		
		return informationDao.getAdverByEditorId(editorId);
	}


	@Override
	public void addAnInfo(Information info) {
		
		informationDao.addAnInfo(info);
		
	}


	@Override
	public void deleteAnInfo(int id) {
		informationDao.deleteAnInfo(id);
		
	}


	@Override
	public void updateAnInfo(Information info) {
		informationDao.updateAnInfo(info);
		
	}


	@Override
	public void checkInfoById(int infoId) {
		informationDao.checkInfoById(infoId);
	}


	@Override
	public void failInfoById(int infoId) {
		informationDao.failInfoById(infoId);
		
	}


	@Override
	public Boolean setDateAndPos(DateAndPos dateAndPos) {
		dateAndPosDao.setDateAndPos(dateAndPos);
		return true;
	}


	@Override
	public Boolean deleteDateAndPos(int dateAndPosId) {
		dateAndPosDao.deleteDateAndPos(dateAndPosId);
		return true;
	}

	@Override
	public String getUnavailableColumnId(Date date, int days) {
		
		try {
			return dateAndPosDao.getUnavailableColumnId(date, days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	
}