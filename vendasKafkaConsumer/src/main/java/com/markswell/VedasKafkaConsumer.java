package com.markswell;

import com.markswell.deserializer.VendaDeserializer;
import com.markswell.model.Venda;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class VedasKafkaConsumer {

    public static void main(String[] args) {
        var properties = new Properties();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, VendaDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, VendaDeserializer.class.getName());

        try(var consumer = new KafkaConsumer<String, Venda>(properties)) {
            consumer.subscribe(Arrays.asList("venda"));

            while(true) {
                var records = consumer.poll(Duration.ofMillis(200));
                records.forEach(r -> System.out.println(r.value().toString()));
            }
        }
    }
}
