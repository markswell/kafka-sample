package com.markswell.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private Long id;
    private String cep;
    private String pais;
    private String bairro;
    private String cidade;
    private String estado;
    private String logradouro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Endereco endereco = (Endereco) o;

        if (!Objects.equals(id, endereco.id)) return false;
        if (!Objects.equals(cep, endereco.cep)) return false;
        if (!Objects.equals(pais, endereco.pais)) return false;
        if (!Objects.equals(bairro, endereco.bairro)) return false;
        if (!Objects.equals(cidade, endereco.cidade)) return false;
        if (!Objects.equals(estado, endereco.estado)) return false;
        return Objects.equals(logradouro, endereco.logradouro);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (logradouro != null ? logradouro.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", pais='" + pais + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", logradouro='" + logradouro + '\'' +
                '}';
    }
}
