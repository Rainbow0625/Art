package com.art.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="Infomation")
public class Infomation implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="contentType",nullable=false)
	private String contentType;
	
	@ManyToOne( targetEntity=Editor.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER ,optional=false)
	@JoinColumn(name="editorId")//加入一列作为外键列
	private Editor editer;
	
	@ManyToOne(targetEntity=ChiefEditor.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER )
	@JoinColumn(name="chiefEditorId")//加入一列作为外键列
	private ChiefEditor chiefEditor;
	
	@Column(name="content",nullable=false)
	private String content;
	
	@OneToMany(targetEntity=DateAndPos.class,cascade = {CascadeType.ALL},mappedBy="infomation",fetch=FetchType.EAGER)
	private List<DateAndPos> dateAndPosS; 
	
	
	
	public Infomation(){}
	
	public int getId() 
	{
        return this.id;
    }
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Editor getEditor(){
		return editer;
	}
	public void setEditor(Editor editor){
		this.editer = editor;
	}
	
	public ChiefEditor getChiefEditor(){
		return chiefEditor;
	}
	public void setChiefEditor(ChiefEditor chiefEditor){
		this.chiefEditor = chiefEditor;
	}
	
	public List<DateAndPos> getDateAndPos() {
		return dateAndPosS;
	}
	public void setDateAndPos(List<DateAndPos> dateAndPosS) {
		this.dateAndPosS=dateAndPosS;
	}
	
	
}
