package com.markswell.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaItem {

    private long id;
    private int quantidade;
    private Produto produto;
    private float valorUnitario;

    @JsonIgnore
    public float getValorTotal() {
        return valorUnitario * quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendaItem vendaItem = (VendaItem) o;

        if (id != vendaItem.id) return false;
        if (quantidade != vendaItem.quantidade) return false;
        if (Float.compare(vendaItem.valorUnitario, valorUnitario) != 0) return false;
        return Objects.equals(produto, vendaItem.produto);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + quantidade;
        result = 31 * result + (produto != null ? produto.hashCode() : 0);
        result = 31 * result + (valorUnitario != +0.0f ? Float.floatToIntBits(valorUnitario) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VendaItem{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", produto=" + produto +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
