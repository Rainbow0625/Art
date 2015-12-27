package com.art.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.art.entity.DateAndPos;
import com.art.entity.Information;


public interface DateAndPosDao 
{
	//select
	public Information getTodayInfoByInfoColumnId(int infoColumnId) throws ParseException;
	public List<DateAndPos> getDateAndPosByInformationId(int informationId);  //chief editor can see the Information when and where to set in the column
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId);  //chief editor can see the InfoColumn 's display history
	
	//add
	public Boolean setDateAndPos(DateAndPos dateAndPos);
	
	//delete
	public Boolean deleteDateAndPos(int dateAndPosId);
	
	
	public String getUnavailableColumnId(Date date, int days) throws ParseException;

}
