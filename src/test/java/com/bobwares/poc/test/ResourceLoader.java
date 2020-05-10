package com.bobwares.poc.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoader {
  public static <T> T load(String path, Class<T> resultType)  {
    ClassLoader classLoader = ResourceLoader.class.getClassLoader();
    File file = new File(classLoader.getResource(path).getFile());
    try {

      DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

      LocalDateTimeDeserializer dateTimeDeserializer = new LocalDateTimeDeserializer(formatter);
      LocalDateTimeSerializer dateTimeSerializer = new LocalDateTimeSerializer(formatter);
      JavaTimeModule javaTimeModule = new JavaTimeModule();
      javaTimeModule.addDeserializer(LocalDateTime.class, dateTimeDeserializer);
      javaTimeModule.addSerializer(LocalDateTime.class, dateTimeSerializer);

      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(javaTimeModule);
      return objectMapper.readValue(file, resultType);

    } catch (IOException e) {
      log.error(e.getMessage());
      throw new ResourceLoaderException(e.getMessage());
    }

  }

  public static <T> void write(String path, Class<T> resultType)  {
    ClassLoader classLoader = ResourceLoader.class.getClassLoader();
    File file = new File(classLoader.getResource(path).getFile());
    try {
      new ObjectMapper().writeValue(file, resultType);

    } catch (IOException e) {
      log.error(e.getMessage());
      throw new ResourceLoaderException(e.getMessage());
    }

  }

  public static <T> T jsonToObject(String jsonString, Class<T> resultType) throws IOException {
    return new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(new ByteArrayInputStream(jsonString.getBytes()), resultType);
  }

}
