package com.art.dao;

import java.util.List;

import com.art.entity.ChiefEditor;

public interface ChiefEditorDao {
	public List<ChiefEditor> getAllChiefEditor();
	public ChiefEditor findChiefEditorByNameAndPassword(String name,String password);
	public void addEditor(ChiefEditor chiefEditor);
	public void deleteEditor(ChiefEditor chiefEditor);
	public void updateEditor(ChiefEditor chiefEditor);
	

}
