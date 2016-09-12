/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.mkyong.web.jsonview.Views;

/**
 *
 * @author ley
 */
public class Message {

    public static final int ERROR = 0;
    public static final int WARN = 1;
    public static final int INFO = 2;
    @JsonView(Views.Public.class)
    private String message;
    @JsonView(Views.Public.class)
    private int type;

    public Message(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
