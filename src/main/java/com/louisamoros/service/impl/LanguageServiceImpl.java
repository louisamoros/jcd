package com.louisamoros.service.impl;

import com.louisamoros.dao.LanguageDAO;
import com.louisamoros.model.Language;
import com.louisamoros.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by louis on 01/03/17.
 */
@Service
public class LanguageServiceImpl implements LanguageService {

  @Autowired
  private LanguageDAO languageDAO;

  @Override
  public Language get(String name) {
    return languageDAO.findOne(name);
  }

  @Override
  public Language update(Language language) {
    return languageDAO.save(language);
  }

  @Override
  public Language create(Language language) {
    return languageDAO.save(language);
  }

  @Override
  public Iterable<Language> getAll() {
    return languageDAO.findAll();
  }

}
