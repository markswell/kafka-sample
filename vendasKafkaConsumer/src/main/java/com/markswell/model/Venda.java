package com.markswell.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    private long id;
    private Cliente cliente;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dataHora;
    private List<VendaItem> vendaItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venda venda = (Venda) o;

        if (id != venda.id) return false;
        if (!Objects.equals(cliente, venda.cliente)) return false;
        if (!Objects.equals(dataHora, venda.dataHora)) return false;
        return Objects.equals(vendaItems, venda.vendaItems);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (vendaItems != null ? vendaItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataHora=" + dataHora +
                ", vendaItems=" + vendaItems +
                '}';
    }
}
