package com.db1group.fairy;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YamlResourceBundle extends ResourceBundle {

    public static final String EMPTY_KEY = "";

    private final Map<String, String> lookup = new HashMap<>();

    public YamlResourceBundle(InputStream stream) {
        Objects.requireNonNull(stream);
        Map<String, Object> metadata = new Yaml().loadAs(stream, Map.class);
        loadLookup(EMPTY_KEY, metadata);
    }

    private void loadLookup(String currentKey, Map<String, Object> map) {
        map.forEach((key, value) -> {
            String newKey = currentKey.isEmpty() ? key : String.format("%s.%s", currentKey, key);
            if (value instanceof Map) {
                this.loadLookup(newKey, (Map<String, Object>) value);
            } else {
                lookup.put(newKey, value.toString());
            }
        });
    }


    @Override
    protected Set<String> handleKeySet() {
        return lookup.keySet();
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.lookup.keySet());
    }

    @Override
    protected Object handleGetObject(String key) {
        Objects.requireNonNull(key);
        return lookup.get(key);
    }

    public static class Control extends ResourceBundle.Control {

        private static final List<String> FORMAT_DEFAULT = Arrays.asList("yml", "yaml");

        public static final Control INSTANCE = new Control();

        private Control() {
        }

        @Override
        public List<String> getFormats(String baseName) {
            Objects.requireNonNull(baseName);
            List<String> values = Stream.concat(super.getFormats(baseName).stream(), FORMAT_DEFAULT.stream()).collect(Collectors.toList());
            return Collections.unmodifiableList(values);
        }

        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException, IOException {
            if (FORMAT_DEFAULT.contains(format)) {
                String bundleName = super.toBundleName(baseName, locale);
                String resourceName = super.toResourceName(bundleName, format);
                InputStream stream = loader.getResourceAsStream(resourceName);
                return Objects.nonNull(stream) ? buildBundle(stream) : null;
            }
            return super.newBundle(baseName, locale, format, loader, reload);
        }

        private YamlResourceBundle buildBundle(InputStream stream) {
            try {
                YamlResourceBundle bundle = new YamlResourceBundle(stream);
                stream.close();
                return bundle;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
