package com.goormtone.goormtoneServer.support;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersistenceContextManager {
  @PersistenceContext
  private EntityManager em;

  public void clearPersistenceContext(){
    em.flush();
    em.clear();
  }
}
