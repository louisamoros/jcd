package com.louisamoros.service;

import com.louisamoros.model.Developper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * Created by louis on 01/03/17.
 */
public interface DevelopperService {

  /**
   * Get.
   *
   * @param id the id of the developper
   * @return a developper
   */
  Developper get(UUID id);

  /**
   * Update.
   *
   * @param developper the developper
   * @return the updated developper
   */
  Developper update(Developper developper);

  /**
   * Create.
   *
   * @param developper the developper
   * @return the created developper
   */
  Developper create(Developper developper);

  /**
   * Get all.
   *
   * @return the developprs
   */
  Iterable<Developper> getAll();

  /**
   * Get all.
   *
   * @param pageable the pageable request
   * @return all developpers
   */
  Page<Developper> getAll(Pageable pageable);

}
