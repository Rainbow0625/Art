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
	public List<Information> getAdverByEditorId(int editorId);
	
	//add
	public void addAnInfo(Information info);
	
	//delete
	public void deleteAnInfo(Information info);
	
	//update
	public void updateAnInfo(Information info);
	public void checkInfoById(int infoId);
	public void failInfoById(int infoId);
	
}
