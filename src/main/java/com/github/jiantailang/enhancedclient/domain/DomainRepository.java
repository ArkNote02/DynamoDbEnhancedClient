package com.github.jiantailang.enhancedclient.domain;

public interface DomainRepository {
  void create();
  void drop();
  void save(Domain domain);
}
