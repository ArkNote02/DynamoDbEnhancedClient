package com.github.jiantailang.enhancedclient.adapters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDbConfiguration {

  @Bean
  public DynamoDbTable<PersistableDomain> table() {
    DynamoDbEnhancedClient client = DynamoDbEnhancedClient.builder()
        .dynamoDbClient(
            DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:4566/"))
                .region(Region.AP_NORTHEAST_1)
                .build())
        .build();
    return client.table("domain", TableSchema.fromBean(PersistableDomain.class));
  }
}
