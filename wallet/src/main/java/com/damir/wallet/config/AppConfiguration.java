/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author codetech
 */

@Configuration
@ComponentScan(basePackages = 
        {"com.damir.wallet.controller", 
            "com.damir.wallet.dao", 
            "com.damir.wallet.config"}
)
public class AppConfiguration {
    
}
