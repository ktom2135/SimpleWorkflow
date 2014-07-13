package com.tom.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Description: <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class CheckBack implements Serializable {
	private static final long serialVersionUID = 48L;
	private Integer id;
	private boolean result;
	private String reason;
	private Application app;
	private Manager manager;

	public CheckBack() {
	}

	public CheckBack(Integer id, boolean result, String reason,
			Application app, Manager manager) {
		this.id = id;
		this.result = result;
		this.reason = reason;
		this.app = app;
		this.manager = manager;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean getResult() {
		return this.result;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return this.reason;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public Application getApp() {
		return this.app;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Manager getManager() {
		return this.manager;
	}
}