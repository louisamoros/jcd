package com.louisamoros.dao;

import com.louisamoros.model.Language;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Louis Amoros on 03/03/17.
 */
public interface LanguageDAO extends PagingAndSortingRepository<Language, String> {

}
