package com.markswell.serializer;

import com.markswell.model.Venda;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.core.JsonProcessingException;

public class VendaSerializer implements Serializer<Venda> {

    @Override
    public byte[] serialize(String s, Venda venda) {
        try {
            return new ObjectMapper().writeValueAsBytes(venda);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
