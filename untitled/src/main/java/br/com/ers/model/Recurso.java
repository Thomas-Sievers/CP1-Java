package br.com.ers.model;

public class Recurso {
    private int id;
    private String nomeDoRecurso;
    private String categoria;
    private boolean disponivel;
    private double valorEstimado;

    public Recurso(int id, String nomeDoRecurso, String categoria, double valorEstimado) {
        this.id = id;
        this.nomeDoRecurso = nomeDoRecurso;
        this.categoria = categoria;
        this.disponivel = true;
        this.valorEstimado = valorEstimado;
    }

    @Override
    public String toString(){
        return "id: " + this.id +
                "| Recurso: " + this.nomeDoRecurso +
                "| Categoria: " + this.categoria +
                "| Disponível: " + this.disponivel +
                "| Valor Estimado: " + this.valorEstimado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoRecurso() {
        return nomeDoRecurso;
    }

    public void setNomeDoRecurso(String nomeDoRecurso) {
        this.nomeDoRecurso = nomeDoRecurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public boolean podeSerAlocado(){
        return disponivel && valorEstimado <= 5000;
    }
}