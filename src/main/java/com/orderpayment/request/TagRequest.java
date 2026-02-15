package com.orderpayment.request;

import com.orderpayment.model.Tag;

public class TagRequest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TagRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TagRequest(String name) {
		super();
		this.name = name;
	}

	public static TagRequest convertToTagResponse(Tag t) {
		return new TagRequest(t.getName());
	}
}
