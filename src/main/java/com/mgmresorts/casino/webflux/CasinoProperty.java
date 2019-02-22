package com.mgmresorts.casino.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasinoProperty {

    private String name;
    private String tagline;
    private String overview;
    
    // standard getters and setters
    
}
