package com.jah.springproduct;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	

	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) {
		
	}
	
}
