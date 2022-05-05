package com.wisdomeleaf.TimeConvertion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisdomeleaf.TimeConvertion.service.TimeConvertionService;


@RestController
@RequestMapping("/api")
public class TimeConvertionController {

	@Autowired
	private TimeConvertionService timeConvertionService;
		
	@GetMapping("/getTime")
	public String getTimeFromService() {
		return timeConvertionService.getTime();
	}
	
}
