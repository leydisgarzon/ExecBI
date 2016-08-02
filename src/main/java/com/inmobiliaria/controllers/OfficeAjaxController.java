/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;
import com.fasterxml.jackson.annotation.JsonView;
import com.inmobiliaria.entities.Office;
import com.mkyong.web.jsonview.Views;
import com.inmobiliaria.model.AjaxResponseBodyOffice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ley
 */
@RestController
public class OfficeAjaxController {
    //Office offi;
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/insert/office/getInsertResult")
    public AjaxResponseBodyOffice getSearchResultViaAjax(@RequestBody Office office) {

		AjaxResponseBodyOffice result = new AjaxResponseBodyOffice();
                
                result.setCode("200");
                result.setMsg("Resultado ok");
		if (isValid(office)) {
			
				result.setCode("200");
				result.setMsg("Resultado ok");
				result.setResult(office);
			 

		} else {
			result.setCode("400");
			result.setMsg("Some field is empty!");
		}

		//AjaxResponseBodyOffice will be converted into json format and send back to client.
		return result;

	}

	private boolean isValid(Office office) {

		boolean valid = true;

		if (office == null) {
			valid = false;
		}

		if ((office.getName().length()==0) || (office.getTelephone()== 0)) {
			valid = false;
		}

		return valid;
	}
    }

