/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mkyong.web.jsonview.Views;
import com.inmobiliaria.entities.Office;

/**
 *
 * @author ley
 */
public class AjaxResponseBodyOffice {
        @JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	Office result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Office getResult() {
		return result;
	}

	public void setResult(Office result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", result=" + result + "]";
	}

}
