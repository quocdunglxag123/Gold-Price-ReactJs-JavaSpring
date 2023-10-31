package com.goldprice.goldprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories("com.goldprice.goldprice")
@EntityScan(basePackages = { "com.goldprice.goldprice" })
@EnableJpaAuditing
public class GoldpriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldpriceApplication.class, args);
	}

}
