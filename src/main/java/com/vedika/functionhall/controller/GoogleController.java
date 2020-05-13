package com.vedika.functionhall.controller;
import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/login")

public class GoogleController {
	
	
	public String google(Principal principal) {
		Map<String,Object> details =(Map<String,Object>)
				((OAuth2Authentication) principal).getUserAuthentication().getDetails();
		String userName=(String)details.get("name");
		return "hi" +userName;
}
}
