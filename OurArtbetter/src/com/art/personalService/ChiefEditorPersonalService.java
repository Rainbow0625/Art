package com.art.personalService;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import com.art.entity.ChiefEditor;


public interface ChiefEditorPersonalService {

	public ChiefEditor findChiefEditor(String name,String password);
	public List<ChiefEditor> getAllChiefEditors();
}
