package com.louisamoros.webservice;

import com.louisamoros.model.Developper;
import com.louisamoros.service.DevelopperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by louis on 01/03/17.
 */
@RestController
public class DevelopperWS {

  @Autowired
  private DevelopperService developperService;

  @RequestMapping(method = RequestMethod.GET, path = "/developper", produces = {"application/json"})
  public ResponseEntity<Iterable<Developper>> getDeveloppers() {
    return ResponseEntity.ok(developperService.getAll());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/developper/{id}", produces = {"application/json"})
  public ResponseEntity<Developper> getDevelopper(@PathVariable UUID id) {
    return ResponseEntity.ok(developperService.get(id));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/developper/language/{name}", produces = {"application/json"})
  public ResponseEntity<List<Developper>> getDeveloppersByLanguage(@PathVariable String name) {
    return ResponseEntity.ok(developperService.getAllByLanguageName(name));
  }

  @RequestMapping(method = RequestMethod.POST, path = "/developper", produces = {"application/json"})
  public ResponseEntity<Developper> createDevelopper(@RequestBody Developper developper) {
    return ResponseEntity.ok(developperService.create(developper));
  }

  @RequestMapping(method = RequestMethod.PUT, path = "/developper/{id}", produces = {"application/json"})
  public ResponseEntity<Developper> updateDevelopper(@PathVariable UUID id, @RequestBody Developper developper) {
    developper.setId(id);
    return ResponseEntity.ok(developperService.update(developper));
  }


}
