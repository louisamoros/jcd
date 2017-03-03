package com.louisamoros.IT;

import com.louisamoros.model.Developper;

/**
 * @author Louis Amoros on 03/03/17.
 */
public class DevelopperWSClient extends WSClient<Developper> {
  public DevelopperWSClient(String endpoint, Class<Developper> clazz) {
    super(endpoint, clazz);
  }
}