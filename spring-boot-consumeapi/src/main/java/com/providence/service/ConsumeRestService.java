package com.providence.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumeRestService {

	private final RestTemplate restTemplate;
	private final String URI = "https://data.providenceri.gov/resource/r6n7-qjr6.json";
	private final String QUERY_INDEX = "?$offset=%s&$limit=1";

	public ConsumeRestService(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	/**
	 * If an index is found create the rest API by using offset and limit to filter to index or else return the first 1000
	 * records
	 * @param index
	 * @return
	 */
	protected String getURI(String index) {
		if (index != null && !index.isEmpty()) {
			return URI + String.format(QUERY_INDEX, index);
		}
		return URI;
	}

	public String getPropertyRecord(String index) {
		String uri = getURI(index);
		System.out.println("Record index ["+index+"]");
		String jsonObject = restTemplate.getForObject(uri, String.class);
		System.out.println(jsonObject);
		return jsonObject;
	}
}
