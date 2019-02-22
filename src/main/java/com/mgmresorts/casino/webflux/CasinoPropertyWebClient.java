package com.mgmresorts.casino.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CasinoPropertyWebClient {

    WebClient client = WebClient.create("https://content.mgmresorts.com/content-api/v1/en");
    
    public Flux<CasinoProperty> consume() {

        /*Mono<Employee> employeeMono = client.get()
            .uri("/employees/{id}", "1")
            .retrieve()
            .bodyToMono(Employee.class);

        employeeMono.subscribe(System.out::println);*/
        
        Flux<CasinoProperty> casinoFlux = client.get()
            .uri("/casino/detail/all")
            .retrieve()
            .bodyToFlux(CasinoProperty.class);
        
        casinoFlux.subscribe(System.out::println);
        return casinoFlux;
    }
}