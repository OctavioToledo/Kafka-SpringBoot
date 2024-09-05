package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //delete (borra el mensaje si no se necesita), compact mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // tiempo de retencion del mensaje, milisegundos, por defecto -1(no se borra)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //  Tamanio en bytes de segmento, 1 GB seria aca, por default tamb es un 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100012"); // Tamanio en bytes de mensajes - defect 1MB
        return TopicBuilder.name("Programador-Java")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();

    }
}
