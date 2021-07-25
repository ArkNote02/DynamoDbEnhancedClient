package com.github.jiantailang.enhancedclient;

import com.github.jiantailang.enhancedclient.domain.Domain;
import com.github.jiantailang.enhancedclient.domain.DomainRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    try (ConfigurableApplicationContext context = SpringApplication.run(Application.class, args)) {
      DomainRepository repository = context.getBean(DomainRepository.class);
      repository.create();
      repository.save(new Domain("partitionKey", "sortKey", new Domain.Child("value")));
      repository.drop();
    }
  }
}
