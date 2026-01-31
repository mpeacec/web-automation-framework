package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
  private static final String CONFIG_FILE = "config.properties";
  private static final Properties PROPERTIES = new Properties();

  static {
    try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
      if (input == null) {
        throw new IllegalStateException("Missing " + CONFIG_FILE + " in test resources");
      }
      PROPERTIES.load(input);
    } catch (IOException e) {
      throw new ExceptionInInitializerError(
          "Failed to load " + CONFIG_FILE + ": " + e.getMessage());
    }
  }

  private ConfigReader() {}

  public static String get(String key) {
    String value = PROPERTIES.getProperty(key);
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("Missing config property: " + key);
    }
    return value.trim();
  }

  public static boolean getBoolean(String key, boolean defaultValue) {
    String value = PROPERTIES.getProperty(key);
    if (value == null) {
      return defaultValue;
    }
    return Boolean.parseBoolean(value.trim());
  }
}
