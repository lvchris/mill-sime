package fr.ippon.mill.farmer.domain;

import java.util.Arrays;

public enum CropType {
  BLE,
  AVOINE,
  ORGE,
  HOUBLON;

  public static CropType verifyCropTypeAndCast(String value) {
    return Arrays.stream(values())
        .filter(cropType -> cropType.name().equalsIgnoreCase(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Unsupported crop type: " + value));
  }
}
