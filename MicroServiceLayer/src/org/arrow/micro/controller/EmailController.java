package org.arrow.micro.controller;

import org.arrow.micro.model.EmailModel;
import org.arrow.micro.service.EmailService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Emailservice")
public class EmailController {

	EmailService emailService;
	
	@RequestMapping(value="/email",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean SendEmail(@RequestBody EmailModel em){
		// TODO: Email Model.	
		return false;
	}
	
	
}
