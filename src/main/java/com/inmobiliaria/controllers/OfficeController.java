/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inmobiliaria.controllers;

/*import com.fasterxml.jackson.annotation.JsonView;
import com.inmobiliaria.model.AjaxResponseBodyOffice;
import com.mkyong.web.jsonview.Views;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;*/
import com.inmobiliaria.entities.Office;

import com.inmobiliaria.services.OfficeService;

import javax.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//import org.springframework.ui.Model;
//cambiar printOffice() por printOffice(Model model) para pasar datos a la vista
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ley
 */

@Controller
public class OfficeController {
    
    @Resource
    private OfficeService officeService;
    
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OfficeController.class);
    
    @RequestMapping(value="/addOffice", method = RequestMethod.GET)
    public String printOffice(Model model) {
                logger.debug("entra en get");
                Office office = new Office();
                model.addAttribute("office", office);
		return "addOffice";
    }
    
    @RequestMapping(value = "/addOffice", method = RequestMethod.POST)
    public String saveOffice(Model model, Office office){
        logger.debug("entra en post");
        if(!isValid(office))
            logger.debug("faltan datos");
        else{
            try {
            
                this.officeService.insertar(office);
            } 
            catch (Exception e) {
            
                logger.debug(e.getMessage());
            }
        }
        return printOffice(model);
    }
    /*@ResponseBody
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/addOffice", method = RequestMethod.POST)
    public AjaxResponseBodyOffice getSearchResultViaAjax(@RequestBody Office office) {
                logger.debug("post");
		AjaxResponseBodyOffice result = new AjaxResponseBodyOffice();
                
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
*/
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

    public OfficeService getOfficeService() {
        return officeService;
    }

    public void setOfficeService(OfficeService officeService) {
        this.officeService = officeService;
    }
        
        
}
