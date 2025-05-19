package Aula11;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SettingsManager {
    private final Map<String, String> Settings;

    private static class SettingsManagerHolder {
        private static final SettingsManager Instance = new SettingsManager();
    }

    private SettingsManager() {
        Settings = new ConcurrentHashMap<>();
        
        Settings.put("estrategia_preferida", "rapida");
        Settings.put("mostrar_informacoes_turisticas", "true");
        Settings.put("mostrar_alertas_seguranca", "true");
        Settings.put("limite_cache", "100");
        Settings.put("linguagem", "pt-BR");
        Settings.put("unidade_distancia", "km");
        Settings.put("unidade_moeda", "BRL");
    }

    public static SettingsManager getInstance() {
        return SettingsManagerHolder.Instance;
    }

    public String getSetting(String key) {
        return Settings.get(key);
    }

    public String getSetting(String key, String defaultValue) {
        return Settings.getOrDefault(key, defaultValue);
    }

    public void setSetting(String key, String value) {
        Settings.put(key, value);
    }

    public void removeSetting(String key) {
        Settings.remove(key);
    }

    public boolean hasSetting(String key) {
        return Settings.containsKey(key);
    }

    public void clearSettings() {
        Settings.clear();
    }

    public void restoreDefaults() {
        clearSettings();
        Settings.put("estrategia_preferida", "rapida");
        Settings.put("mostrar_informacoes_turisticas", "true");
        Settings.put("mostrar_alertas_seguranca", "true");
        Settings.put("limite_cache", "100");
        Settings.put("linguagem", "pt-BR");
        Settings.put("unidade_distancia", "km");
        Settings.put("unidade_moeda", "BRL");
    }
}
