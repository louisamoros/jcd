package com.louisamoros.dao;

import com.louisamoros.model.Developper;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author Louis Amoros on 03/03/17.
 */
public interface DevelopperDAO extends PagingAndSortingRepository<Developper, UUID> {

  /**
   * Find by language name.
   *
   * @param languageName the language name
   * @return the list developper
   */
  List<Developper> findByLanguageName(String languageName);

}
