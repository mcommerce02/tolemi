package com.providence.controller;

import com.providence.service.ConsumeRestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

	private ConsumeRestService consumeRestService;

	public PropertyController(ConsumeRestService consumeRestService) {
		this.consumeRestService = consumeRestService;
	}

	@GetMapping("records/{index}")
	public String getJson(@PathVariable("index") String index) {
		return consumeRestService.getPropertyRecord(index);
	}
}
