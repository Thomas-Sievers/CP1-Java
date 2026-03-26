package br.com.ers.model;

import java.util.Date;

public class Alocacao {
    private int colaboradorId;
    private int recursoId;
    private Date data;
    private String observacao;

    public Alocacao(int colaboradorId, int recursoId, Date data, String observacao) {
        this.colaboradorId = colaboradorId;
        this.recursoId = recursoId;
        this.data = data;
        this.observacao = observacao;
    }

    @Override
    public String toString(){
        return "Id do Colaborador: " + this.colaboradorId +
                "| Id do Recurso: " + this.recursoId +
                "| Data: " + this.data +
                "| Observação: " + this.observacao;
    }

    public int getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(int colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
