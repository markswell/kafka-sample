package com.markswell.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaItem {

    private long id;
    private int quantidade;
    private Produto produto;
    private float valorUnitario;

    public float getValorTotal() {
        return valorUnitario * quantidade;
    }
}
