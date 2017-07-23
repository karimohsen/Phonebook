package com.orange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Karim on 7/10/2017.
 */
@SpringBootApplication
public class EntryPoint {


    public static void main(String[] args) {
        //to create the servlet container and host this servlet
        SpringApplication.run(EntryPoint.class, args);
    }

}
