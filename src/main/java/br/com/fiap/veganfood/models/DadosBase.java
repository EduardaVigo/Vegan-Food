package br.com.fiap.VeganFood.models;

public abstract class DadosBase {
     private String foto;
     private String nome;
     private String comidaFav;

    
    public DadosBase(String foto, String nome, String comidaFav) {
        this.foto = foto;
        this.nome = nome;
        this.comidaFav = comidaFav;
    }
    
    
    public DadosBase() {
    }


    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return comidaFav;
    }
    public void setDescricao(String comidaFav) {
        this.comidaFav = comidaFav;
    }
  

}
