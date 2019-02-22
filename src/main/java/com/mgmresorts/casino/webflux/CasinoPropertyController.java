package com.mgmresorts.casino.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/casino/detail")
@Slf4j
public class CasinoPropertyController {

    private CasinoRepository casinoRepository;

    public CasinoPropertyController(CasinoRepository casinoRepository) {
        this.casinoRepository = casinoRepository;
    }

    @GetMapping("/{id}")
    private Mono<CasinoProperty> getCasinoPropertyById(@PathVariable String id) {
    	System.out.println("getCasinoPropertyById  - Entering"+id);
        return Mono.just(new CasinoProperty("id1", "tgline1","ov1"));
    }

    @GetMapping
    private Flux<CasinoProperty> getAllEmployees() {
    	System.out.println("getAllEmployees - Entering");
        return casinoRepository.findAllEmployees();
    }

    /*@PostMapping("/update")
    private Mono<Employee> updateEmployee(@RequestBody Employee employee) {
        return casinoRepository.updateEmployee(employee);
    }*/

}
