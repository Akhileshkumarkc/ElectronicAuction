package org.arrow.micro.controller;

import org.arrow.micro.email.EmailModel;
import org.arrow.micro.email.EmailReqParamModel;
import org.arrow.micro.email.EmailTemplateClass;
import org.arrow.micro.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@RestController
@RequestMapping("/Emailservice")
public class EmailController {

	EmailService emailService;
	@Autowired
	private MailSender mailsender;
	
	@RequestMapping(value="/Sendemail",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody boolean SendEmail(@RequestBody  EmailReqParamModel email){
		
		SimpleMailMessage message = new SimpleMailMessage();
		EmailTemplateClass.init();
		EmailModel em = EmailTemplateClass.getTemplate(EmailTemplateClass.REGISTERATION_EMAIL);
		message.setTo(email.getUser().getEmail());
		message.setSubject(em.subject);
		message.setText(em.messageBody);
		mailsender.send(message);
		
		return true;
		
	}
	
	
}
