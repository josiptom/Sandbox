package com.sandboxproject.sandbox;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaSandbox {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSandbox.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 1_000_000; i++) {
				kafkaTemplate.send("testTopic","test test" + i);
			}
		};
	}
}
