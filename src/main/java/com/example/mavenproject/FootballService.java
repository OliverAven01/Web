package com.example.mavenproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FootballService {

    private final WebClient webClient;

    @Value("${api.football.base-url}")
    private String apiBaseUrl;

    @Value("${api.football.key}")
    private String apiKey;

    @Autowired
    public FootballService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(apiBaseUrl).build();
    }

    public Mono<String> getLiveScores() {
        return this.webClient.get()
            .uri("https://v3.football.api-sports.io")
            .header("x-rapidapi-key", apiKey)
            .retrieve()
            .bodyToMono(String.class);
    }
}
