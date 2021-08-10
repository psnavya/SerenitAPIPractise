package com.aviation.apiautomation.helpers;

public enum KeyHelper {
    KEY_HELPER_VALID_KEY("com.aviationapi.key"),
    KEY_HELPER_INVALID_KEY("com.aviationapi.invalidkey");

    String key;
    KeyHelper(String key) {
        this.key=key;

    }
    public String getKey() {
        return key;
    }
}
