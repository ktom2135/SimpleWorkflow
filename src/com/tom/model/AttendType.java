package com.tom.model;

import java.io.Serializable;

/**
 * Description: <br/>
 * Copyright (C), 2001-2010, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: Login/Login out type <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class AttendType implements Serializable {
	private static final long serialVersionUID = 48L;

	private Integer id;
	private String name;
	private double amerce;

	public AttendType() {
	}

	public AttendType(Integer id, String name, double amerce) {
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}

	public double getAmerce() {
		return this.amerce;
	}
}