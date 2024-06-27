
package com.web_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class WebController {

	@Autowired
	WebClient webClient;

	@GetMapping("/mob2")
	public Mono<String> getAllMongoDbEntities() {
		return webClient.get().uri("/mob2").retrieve().bodyToMono(String.class);
	}

	@GetMapping("/mob3/{id}")
	public Mono<String> getMongoDbEntityById(@PathVariable String id) {
		return webClient.get().uri("/mob3/{id}", id).retrieve().bodyToMono(String.class);
	}

	@PostMapping("/mob")
	public Mono<String> createMongoDbEntity(@RequestBody String requestBody) {
		return webClient.post().uri("/mob").contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
				.body(BodyInserters.fromValue(requestBody)).retrieve().bodyToMono(String.class);
	}

	@PutMapping("/mob5")
	public Mono<String> updateMongoDbEntity(@RequestBody String requestBody) {
		return webClient.put().uri("/mob5").contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(requestBody)).retrieve().bodyToMono(String.class);
	}

	@DeleteMapping("/mob4/{id}")
	public Mono<String> deleteMongoDbEntity(@PathVariable String id) {
		return webClient.delete().uri("/mob4/{id}", id).retrieve().bodyToMono(String.class);
	}
}
