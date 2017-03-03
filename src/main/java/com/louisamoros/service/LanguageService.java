package com.louisamoros.service;

import com.louisamoros.model.Language;

/**
 * Created by louis on 01/03/17.
 */
public interface LanguageService {

  /**
   * Get.
   *
   * @param name the name of the language
   * @return a language
   */
  Language get(String name);

  /**
   * Update.
   *
   * @param language the language
   * @return the updated language
   */
  Language update(Language language);

  /**
   * Create.
   *
   * @param language the language
   * @return the created language
   */
  Language create(Language language);

  /**
   * Get all.
   *
   * @return the developprs
   */
  Iterable<Language> getAll();

}
