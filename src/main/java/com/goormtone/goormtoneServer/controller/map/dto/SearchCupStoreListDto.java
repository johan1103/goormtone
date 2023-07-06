package com.goormtone.goormtoneServer.controller.map.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCupStoreListDto {
  private List<SearchCupStore> cupStores;
  Integer size;
  public static SearchCupStoreListDto ofSearchCupStore(List<SearchCupStore> stores){
    return new SearchCupStoreListDto(stores, stores.size());
  }
}
