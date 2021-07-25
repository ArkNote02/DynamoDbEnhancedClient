package com.github.jiantailang.enhancedclient.domain;

public class Domain {

  private String partitionKey;
  private String sortKey;
  private Child child;

  public Domain(String partitionKey, String sortKey, Child child) {
    this.partitionKey = partitionKey;
    this.sortKey = sortKey;
    this.child = child;
  }

  public String getPartitionKey() {
    return partitionKey;
  }

  public String getSortKey() {
    return sortKey;
  }

  public Child getChild() {
    return child;
  }

  public static class Child {

    private String value;

    public Child(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }
}
