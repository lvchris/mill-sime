package fr.ippon.mill.error.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class Assert {

  private Assert() {
  }

  public static void assertNotNull(String fieldName, Object field) {
    if (Objects.isNull(field)) {
      throw new AssertionException(String.format("Field \"%s\" is required (value provided: null", fieldName));
    }
  }

  public static void assertNotBlank(String fieldName, String field) {
    assertNotNull(fieldName, field);
    if (StringUtils.isBlank(field)) {
      throw new AssertionException(String.format("Field \"%s\" cannot be blank (value provided: \"%s\")", fieldName, field));
    }
  }
}
