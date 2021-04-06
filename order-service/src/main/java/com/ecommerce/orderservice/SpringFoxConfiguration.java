package com.ecommerce.orderservice;


import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SpringFoxConfiguration {

 private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
         new HashSet<>(Arrays.asList("application/json",
                 "application/xml"));
// @Bean
// public Docket api() {
//  return new Docket(DocumentationType.SWAGGER_2)
//          .produces(DEFAULT_PRODUCES_AND_CONSUMES)
//          .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
// }
}
