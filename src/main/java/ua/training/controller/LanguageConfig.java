package ua.training.controller;

import java.util.Locale;
import java.util.ResourceBundle;

class LanguageConfig {

    private static final String ENGLISH = "EN";
    private static final String UKRAINIAN = "UA";
    private static final String BUNDLE_EN = "Messages_en";
    private static final String BUNDLE_UA = "Messages_ua";

    static ResourceBundle selectLanguage() {
//        return ResourceBundle.getBundle(BUNDLE_UA, new Locale("uk", "UA"));
        return ResourceBundle.getBundle(BUNDLE_EN, Locale.ENGLISH);
    }
}
