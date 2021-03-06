package com.mercury.controller.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.common.ControllerResponse;
import com.mercury.service.mail.MailService;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/service/mails")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/check")
	public <T extends Object> T emailCheck(String target) throws Exception {
		ControllerResponse<String> res = new ControllerResponse<>();
		
		try {
			res.setMessage("Success Send Mail :) "); 
			res.setResult(mailService.certiNumber(target));
			res.setResultCode(HttpStatus.OK);
		} catch (Exception e) {
			res.setMessage(e.getMessage()); 
			res.setResult(null);
			res.setResultCode(HttpStatus.OK);
		}
		
		return (T) res;
	}
	
}
