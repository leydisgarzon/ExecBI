/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.inmobiliaria.entities.Employee;
import com.inmobiliaria.util.Message;
import com.mkyong.web.jsonview.Views;

/**
 *
 * @author ley
 */
public class AjaxResponseBodyEmployee {

        @JsonView(Views.Public.class)
	Message msg;
	@JsonView(Views.Public.class)
	Employee result;

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public Employee getResult() {
        return result;
    }

    public void setResult(Employee result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "AjaxResponseResult [msg=" + msg.getMessage() + ", code=" + msg.getType() + ", result=" + result + "]";
    }

}
