package com.github.jiantailang.enhancedclient.adapters;

import com.github.jiantailang.enhancedclient.domain.Domain;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class PersistableDomain {

  private String partitionKey;
  private String sortKey;
  private PersistableChild child;

  public PersistableDomain() {}

  public PersistableDomain(Domain domain) {
    this.partitionKey = domain.getPartitionKey();
    this.sortKey = domain.getSortKey();
    this.child = new PersistableChild(domain.getChild());
  }

  @DynamoDbPartitionKey
  public String getPartitionKey() {
    return partitionKey;
  }
  public void setPartitionKey(String partitionKey) {
    this.partitionKey = partitionKey;
  }

  @DynamoDbSortKey
  public String getSortKey() {
    return sortKey;
  }
  public void setSortKey(String sortKey) {
    this.sortKey = sortKey;
  }

  public PersistableChild getChild() {
    return child;
  }
  public void setChild(PersistableChild child) {
    this.child = child;
  }

  @DynamoDbBean
  public static class PersistableChild {

    private String value;

    public PersistableChild() {}

    public PersistableChild(Domain.Child child) {
      this.value = child.getValue();
    }

    public String getValue() {
      return value;
    }
    public void setValue(String value) {
      this.value = value;
    }
  }
}
