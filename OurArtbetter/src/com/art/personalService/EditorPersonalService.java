package com.art.personalService;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import com.art.entity.Editor;

public interface EditorPersonalService {
	
	public Editor findEditor(String name,String password);
	public List<Editor> getAllEditors();
}
