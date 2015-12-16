package com.art.entity;

import java.util.Date;
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
@Table(name="Information")
public class Information implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="contentType",nullable=false)
	private String contentType;
	
	@ManyToOne( targetEntity=Editor.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="editorId",nullable=false,updatable=false) //一旦创建确认不可修改
	private Editor editor;
	
	@ManyToOne(targetEntity=ChiefEditor.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY )
	@JoinColumn(name="chiefEditorId",nullable=true,updatable=false)//一旦创建确认不可修改
	private ChiefEditor chiefEditor;
	
	@Column(name="content",nullable=false)
	private String content;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="createTime",nullable=false,updatable=false)
	private Date createTime;
	
	@Column(name="nextTime",nullable=true)
	private Date nextTime;
	
	@Column(name="state",nullable=false)
	private int state;   //  1 haven't check  2 pass  3 not pass
	
	@OneToMany(targetEntity=DateAndPos.class,cascade = {CascadeType.ALL},mappedBy="information",fetch=FetchType.LAZY)
	private List<DateAndPos> dateAndPosS; 
	
	
	
	public Information(){}
	
	public int getId() 
	{
        return this.id;
    }
	public void setId(int id) 
	{
         this.id=id;
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
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setState(int state)
	{
		this.state = state;
	}
	public int getState()
	{
		 return this.state;
	}
	
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public Date getCreateTime()
	{
		 return this.createTime;
	}
	
	public void setNextTime(Date nextTime)
	{
		this.nextTime = nextTime;
	}
	public Date getNextTime()
	{
		 return this.nextTime;
	}
	
	
	
	public Editor getEditor(){
		return editor;
	}
	public void setEditor(Editor editor){
		this.editor = editor;
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
