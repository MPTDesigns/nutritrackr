package com.codeup.nutritrackr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = {NutritrackrApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class NutritrackrApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritrackrApplication.class, args);
	}
}
