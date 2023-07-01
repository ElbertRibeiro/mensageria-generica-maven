package com.elbertribeiro.mensageria.kafka;

class KafkaDto {
    private String hostKafka;

    public KafkaDto(String hostKafka) {
        this.hostKafka = hostKafka;
    }

    public String getHostKafka() {
        return hostKafka;
    }
}
