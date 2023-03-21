package br.com.fiap.VeganFood.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Conta extends DadosBase {

    private Integer id;
    private Categoria categoria;
    private List<Cliente> cliente;
    private Curador curador;

    public Conta() {
    }

    public Conta(String foto, String nome, String comidaFav, Categoria categoria, List<Cliente> clientes) {
        super(foto, nome, comidaFav);
        this.categoria = categoria;
        this.clientes = clientes;

    }

}
