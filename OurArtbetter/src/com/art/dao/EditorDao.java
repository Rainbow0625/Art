package com.art.dao;

import java.util.List;

import com.art.entity.Editor;

public interface EditorDao {

	public List<Editor> getAllEditor();
	public Editor findEditorByNameAndPassword(String name,String password);
	public void addEditor(Editor editor);
	public void deleteEditor(Editor editor);
	public void updateEditor(Editor editor);
}
