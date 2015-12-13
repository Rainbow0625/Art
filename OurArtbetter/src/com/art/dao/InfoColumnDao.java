package com.art.dao;

import com.art.entity.InfoColumn;

public interface InfoColumnDao 
{
	//select
	public InfoColumn getInfoColumnById(int infoColumnById);
	public double getInforColumnPriceById(int infoColumnById);
	public String getInforColumnTypeById(int infoColumnById);
	
	//update
	

}
