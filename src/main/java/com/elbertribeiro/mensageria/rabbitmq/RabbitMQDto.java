package com.elbertribeiro.mensageria.rabbitmq;

class RabbitMQDto {
    private String host;
    private Integer port;
    private String usuario;
    private String senha;
    private String projetoTag;

    public RabbitMQDto(String host, Integer port, String usuario, String senha, String projetoTag) {
        this.host = host;
        this.port = port;
        this.usuario = usuario;
        this.senha = senha;
        this.projetoTag = projetoTag;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getProjetoTag() {
        return projetoTag;
    }
}
