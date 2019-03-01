package com.ssm.chapter14.pojo;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = -4126322500808393404L;
	private Long id;
	private String roleName;
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
