package com.db1group.fairy;

import java.io.InputStream;

class YamlResourceBundleTestDataBuilder {

    private YamlResourceBundleTestDataBuilder() {
    }

    static InputStream messagesStream() {
        return YamlResourceBundleTestDataBuilder.class.getResourceAsStream("/i18n/messages.yaml");
    }


    static InputStream messagesEnUSStream() {
        return YamlResourceBundleTestDataBuilder.class.getResourceAsStream("/i18n/messages_en_US.yaml");
    }


    static InputStream messagesPtBRStream() {
        return YamlResourceBundleTestDataBuilder.class.getResourceAsStream("/i18n/messages_pt_BR.yml");
    }

    static YamlResourceBundle yamlResourceBundleWithMessages() {
        return new YamlResourceBundle(messagesStream());
    }
}
