package com.web_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Webcl {

	@Autowired
	WebClient webClient;

	@GetMapping(value = "/story")
	public String getAim() {
		return webClient.get().uri("/aim").retrieve().bodyToMono(String.class).block();
	}

	@GetMapping(value = "/ship")
	public String getBlack() {
		return webClient.get().uri("/black").retrieve().bodyToMono(String.class).block();
	}

	@GetMapping(value = "/anime")
	public String getOne() {
		return webClient.get().uri("/one").retrieve().bodyToMono(String.class).block();
	}

}
