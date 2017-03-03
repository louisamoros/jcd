package com.louisamoros.IT;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.mapper.ObjectMapperDeserializationContext;
import com.jayway.restassured.mapper.ObjectMapperSerializationContext;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author Louis Amoros on 03/03/17.
 */
public abstract class WSClient<T> {

  /**
   * Use this mapper for return JSON or XML as String.
   */
  public static final com.jayway.restassured.mapper.ObjectMapper STRING_MAPPER =
      new com.jayway.restassured.mapper.ObjectMapper() {
        @Override
        public String deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
          return objectMapperDeserializationContext.getDataToDeserialize().asString();
        }

        @Override
        public String serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
          return null;
        }
      };
  private final String endpoint;
  private final Class<T> clazz;

  public WSClient(String endpoint, Class<T> clazz) {
    this.endpoint = endpoint;
    this.clazz = clazz;
  }

  /**
   * Execute a get request.
   *
   * @param params      query params. Can't be null but can be empty
   * @param statusCode  http status code
   * @param contentType content type (JSON, XML...)
   * @param mapper      use a mapper if needed. Can be null
   * @return object
   */
  public T get(Map<String, ?> params, int statusCode, ContentType contentType, com.jayway.restassured.mapper.ObjectMapper mapper) {
    RequestSpecification req = given().contentType(contentType);
    params.forEach((k, v) -> {
      if (v instanceof Collection<?>) {
        req.param(k, (Collection<?>) v);
      } else {
        req.param(k, v);
      }
    });
    if (statusCode == 200) {
      return mapToDto(req, mapper);
    }
    req.when()
        .get(endpoint)
        .then()
        .statusCode(statusCode);
    return null;
  }

  private T mapToDto(RequestSpecification req, com.jayway.restassured.mapper.ObjectMapper mapper) {
    ExtractableResponse response = req.when()
        .get(endpoint)
        .then()
        .statusCode(200)
        .extract();
    return mapper == null ? response.as(clazz) : response.as(clazz, mapper);
  }
  private List<T> extractAsList(InputStream is) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      JavaType type = mapper.getTypeFactory().constructParametrizedType(List.class, List.class, clazz);
      return mapper.readValue(is, type);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}