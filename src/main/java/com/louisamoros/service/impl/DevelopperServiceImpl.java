package com.louisamoros.service.impl;

import com.louisamoros.dao.DevelopperDAO;
import com.louisamoros.dao.LanguageDAO;
import com.louisamoros.model.Developper;
import com.louisamoros.model.Language;
import com.louisamoros.service.DevelopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by louis on 01/03/17.
 */
@Service
public class DevelopperServiceImpl implements DevelopperService {

  @Autowired
  private DevelopperDAO developperDAO;

  @Autowired
  private LanguageDAO languageDAO;

  @Override
  public Developper get(UUID id) {
    return developperDAO.findOne(id);
  }

  @Override
  public Developper update(Developper developper) {
    return developperDAO.save(developper);
  }

  @Override
  public Developper create(Developper developper) {
    developper.setId(UUID.randomUUID());
    return developperDAO.save(developper);
  }

  @Override
  public Iterable<Developper> getAll() {
    return developperDAO.findAll();
  }

  @Override
  public List<Developper> getAllByLanguageName(String languageName) {
    Language language = languageDAO.findOne(languageName);
    return developperDAO.findByLanguage(language);
  }

}
