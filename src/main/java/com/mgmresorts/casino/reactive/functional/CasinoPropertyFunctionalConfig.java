package com.mgmresorts.casino.reactive.functional;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mgmresorts.casino.webflux.CasinoProperty;
import com.mgmresorts.casino.webflux.CasinoPropertyWebClient;
import com.mgmresorts.casino.webflux.CasinoRepository;
import com.mgmresorts.casino.webflux.Employee;
import com.mgmresorts.casino.webflux.EmployeeRepository;

@Configuration
public class CasinoPropertyFunctionalConfig {

    @Bean
    CasinoRepository casinoRepository() {
        return new CasinoRepository();
    }
    
    @Bean
    CasinoPropertyWebClient casinoPropertyWebClient() {
        return new CasinoPropertyWebClient();
    }

    @Bean
    RouterFunction<ServerResponse> getAllCasinoRoute() {
      return route(GET("/v1/casino/detail"), 
        req -> ok().body(
          casinoRepository().findAllEmployees(), CasinoProperty.class));
    }

    /*@Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
      return route(GET("/employees/{id}"), 
        req -> ok().body(
          casinoRepository().findEmployeeById(req.pathVariable("id")), CasinoProperty.class));
    }

    @Bean
    RouterFunction<ServerResponse> updateEmployeeRoute() {
      return route(POST("/employees/update"), 
        req -> req.body(toMono(Employee.class))
                  .doOnNext(employeeRepository()::updateEmployee)
                  .then(ok().build()));
    }*/

    @Bean
    RouterFunction<ServerResponse> ccomposedRoutes() {
      return 
          route(GET("/v1/casino/detail"), 
            req -> ok().body(
              casinoRepository().findAllEmployees(), CasinoProperty.class))
          ;
            
          /*.and(route(GET("/employees/{id}"), 
            req -> ok().body(
              employeeRepository().findEmployeeById(req.pathVariable("id")), Employee.class)))
            
          .and(route(POST("/employees/update"), 
            req -> req.body(toMono(Employee.class))
                      .doOnNext(employeeRepository()::updateEmployee)
                      .then(ok().build())));*/
    }

    @Bean
    public SecurityWebFilterChain sspringSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf()
            .disable()
            .authorizeExchange()
            .anyExchange()
            .permitAll();
        return http.build();
    }
}
