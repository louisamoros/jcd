package com.louisamoros.webservice;

import com.louisamoros.model.Language;
import com.louisamoros.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by louis on 01/03/17.
 */
@RestController
public class LanguageWS {

  @Autowired
  private LanguageService languageService;

  @RequestMapping(method = RequestMethod.GET, path = "/language", produces = {"application/json"})
  public ResponseEntity<Iterable<Language>> getLanguages() {
    return ResponseEntity.ok(languageService.getAll());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/language/{name}", produces = {"application/json"})
  public ResponseEntity<Language> getLanguage(@PathVariable String name) {
    return ResponseEntity.ok(languageService.get(name));
  }

  @RequestMapping(method = RequestMethod.POST, path = "/language", produces = {"application/json"})
  public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
    return ResponseEntity.ok(languageService.create(language));
  }

  @RequestMapping(method = RequestMethod.PUT, path = "/language/{name}", produces = {"application/json"})
  public ResponseEntity<Language> updateLanguage(@PathVariable String name, @RequestBody Language language) {
    language.setName(name);
    return ResponseEntity.ok(languageService.update(language));
  }


}
