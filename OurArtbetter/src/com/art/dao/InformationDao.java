package com.art.dao;

import java.util.List;

import com.art.entity.Information;

public interface InformationDao 
{
	//select
	public Information getInformationById(int informationId);
	public List<Information> getAllAdver();
	public List<Information> getAllInfo(); 
	public List<Information> getInformationByEditorId(int editorId);
	public List<Information> getInformationByChiefEditorId(int chiefEditorId);
	
	//add
	
	//delete
	
	//update
	
	
}
