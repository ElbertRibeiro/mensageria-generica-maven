package com.elbertribeiro.mensageria.rabbitmq;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

class RabbitMQLoadFile {
    private static final String FILE_RABBITMQ = "rabbitmq.properties";
    private static final String HOST_RABBITMQ = "mensageria.rabbitmq.host";
    private static final String PORT_RABBITMQ = "mensageria.rabbitmq.port";
    private static final String USUARIO_RABBITMQ = "mensageria.rabbitmq.usuario";
    private static final String SENHA_RABBITMQ = "mensageria.rabbitmq.senha";
    private static final String PROJETO = "mensageria.rabbitmq.projetoTag";

    public RabbitMQLoadFile() {
    }

    public RabbitMQDto loadConfig() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_RABBITMQ)) {
            if (inputStream == null) throw new IOException("Arquivo de configuração não encontrado.\n " +
                    "Adicione o arquivo " + FILE_RABBITMQ + " ao resource");

            Properties properties = new Properties();
            properties.load(inputStream);

            String host = Optional.ofNullable(properties.getProperty(HOST_RABBITMQ))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_RABBITMQ + " a propriedade " + HOST_RABBITMQ));
            Integer port = Optional.of(Integer.valueOf(properties.getProperty(PORT_RABBITMQ)))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_RABBITMQ + " a propriedade " + PORT_RABBITMQ));
            String usuario = Optional.ofNullable(properties.getProperty(USUARIO_RABBITMQ))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_RABBITMQ + " a propriedade " + USUARIO_RABBITMQ));
            String senha = Optional.ofNullable(properties.getProperty(SENHA_RABBITMQ))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_RABBITMQ + " a propriedade " + SENHA_RABBITMQ));
            String projetoTag = Optional.ofNullable(properties.getProperty(PROJETO))
                    .orElseThrow(() -> new RuntimeException("Informe no arquivo " + FILE_RABBITMQ + " a propriedade " + PROJETO));
            return new RabbitMQDto(host, port, usuario, senha, projetoTag);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
