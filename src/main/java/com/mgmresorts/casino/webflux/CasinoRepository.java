package com.mgmresorts.casino.webflux;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CasinoRepository {
    
    static Map<String,Employee> casinoProperties;

    //static Map<String,String> employeeAccessData;
    
    @Autowired
    CasinoPropertyWebClient casinoPropertyWebClient;

    static
    {
    }
    
    /*public Mono<CasinoProperty> findCasinoPropertyById(String id)
    {
        return Mono.just(employeeData.get(id));
    }*/
    
    public Flux<CasinoProperty> findAllEmployees()
    {
        return casinoPropertyWebClient.consume();
    }
    
    /*public Mono<Employee> updateEmployee(Employee employee)
    {
        Employee existingEmployee=employeeData.get(employee.getId());
        if(existingEmployee!=null)
        {
            existingEmployee.setName(employee.getName());
        }
        return Mono.just(existingEmployee);
    }*/
}
