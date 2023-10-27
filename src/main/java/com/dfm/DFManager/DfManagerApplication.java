package com.dfm.DFManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DfManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfManagerApplication.class, args);
		//App start page: http://localhost:8080/users
		//App start page: http://localhost:8080/players
        //App start page: http://localhost:8080/clubs
	}

}
