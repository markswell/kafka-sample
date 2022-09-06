package com.markswell.resource;

import com.markswell.model.Venda;
import com.markswell.serializer.VendaSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.ws.rs.*;

import java.util.Properties;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/venda")
public class VendaResource {

    @GET
    public String vendaTeste() {
        String teste = "JAX-RS funcionando";
        return teste;
    }
    
    @POST
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public Venda createProduto(Venda venda) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, VendaSerializer.class.getName());

        try(KafkaProducer<String, Venda> producer = new KafkaProducer<>(properties)) {
            ProducerRecord<String, Venda> record = new ProducerRecord<String, Venda>("venda", venda);
            producer.send(record);
        }

        return venda;
    }

}
