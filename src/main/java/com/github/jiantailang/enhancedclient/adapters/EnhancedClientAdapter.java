package com.github.jiantailang.enhancedclient.adapters;

import com.github.jiantailang.enhancedclient.domain.Domain;
import com.github.jiantailang.enhancedclient.domain.DomainRepository;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

@Component
public class EnhancedClientAdapter implements DomainRepository {

  private final DynamoDbTable<PersistableDomain> table;

  public EnhancedClientAdapter(DynamoDbTable<PersistableDomain> table) {
    this.table = table;
  }

  @Override
  public void create() {
    table.createTable();
  }

  @Override
  public void drop() {
    table.deleteTable();
  }

  @Override
  public void save(Domain domain) {
    table.putItem(new PersistableDomain(domain));
  }
}
