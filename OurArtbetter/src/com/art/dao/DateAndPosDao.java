package com.art.dao;

import java.util.List;

import com.art.entity.DateAndPos;
import com.art.entity.Information;


public interface DateAndPosDao 
{
	//select
	public Information getTodayInfoByInfoColumnId(int infoColumnId);
	public List<DateAndPos> getDateAndPosByInformationId(int informationId);  //chief editor can see the Information when and where to set in the column
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId);  //chief editor can see the InfoColumn 's display history
	
	//add
	public void setDateAndPos(DateAndPos dateAndPos);
	
	//delete
	public void deleteDateAndPos(DateAndPos dateAndPos);

}
