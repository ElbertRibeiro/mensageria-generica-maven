package com.elbertribeiro.mensageria.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

class KafkaLoadFile {
    private static final String FILE_KAFKA = "kafka.properties";
    private static final String HOST_KAFKA = "mensageria.kafka.host";

    public KafkaDto loadConfig() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_KAFKA)) {
            if (inputStream == null) throw new IOException("Arquivo de configuração não encontrado.\n " +
                    "Adicione o arquivo " + FILE_KAFKA + " ao resource");

            Properties properties = new Properties();
            properties.load(inputStream);

            String hostKafka = Optional.ofNullable(properties.getProperty(HOST_KAFKA))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_KAFKA + " a propriedade " + HOST_KAFKA));

            return new KafkaDto(hostKafka);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
