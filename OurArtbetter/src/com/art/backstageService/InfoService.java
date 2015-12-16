package com.art.backstageService;

import java.util.List;

import com.art.entity.DateAndPos;
import com.art.entity.InfoColumn;
import com.art.entity.Information;

public interface InfoService 
{
	//DateAndPos DAO
	public Information getTodayInfoByColumnId(int infoColumnId);
	
	public List<DateAndPos> getDateAndPosByInformationId(int informationId);  //chief editor can see the Information when and where to set in the column
	
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId);  //chief editor can see the InfoColumn 's display history
	
	public void setDateAndPos(DateAndPos dateAndPos);
	public void deleteDateAndPos(DateAndPos dateAndPos);
	
	
	//information  DAO
	public Information getInformationById(int informationId);
	
	public List<Information> getAllInfo();
	
	public List<Information> getAllAdver();
	
	public List<Information> getInformationByEditorId(int editorId);
	
	public List<Information> getAdverByEditorId(int editorId);
	
	public List<Information> getInformationByChiefEditorId(int chiefEditorId);
	
	
	public void addAnInfo(Information info);
	public void deleteAnInfo(Information info);
	public void updateAnInfo(Information info) ;
	public void checkInfoById(int infoId);
	public void failInfoById(int infoId);
	
	//inforColumn DAO
	public InfoColumn getInfoColumnById(int infoColumnById);
	
	public double getInforColumnPriceById(int infoColumnById);
	
	public String getInforColumnTypeById(int infoColumnById);
	
	
	
	
	
}
