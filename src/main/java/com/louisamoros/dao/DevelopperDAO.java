package com.louisamoros.dao;

import com.louisamoros.model.Developper;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author Louis Amoros on 03/03/17.
 */
public interface DevelopperDAO extends PagingAndSortingRepository<Developper, UUID> {
}
