package br.com.ers.model;

import java.time.LocalDate;

public class Colaborador {
    private int id;
    private String nome;
    private String cargo;
    private double salario;
    private boolean homeOffice;
    private boolean ativo;
    private LocalDate dataDeAdmissao;

    public Colaborador(int id, String nome, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.homeOffice = false;
        this.ativo = true;
        this.dataDeAdmissao = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Cargo: %s | Salário: R$ %.2f | Home Office: %s | Ativo: %s",
                id, nome, cargo, salario, homeOffice, (ativo ? "Sim" : "Não"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isHomeOffice() {
        return homeOffice;
    }

    public void setHomeOffice(boolean homeOffice) {
        this.homeOffice = homeOffice;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public void promover(String novoCargo, double novoSalario) {
        this.cargo = novoCargo;
        this.salario = novoSalario;
    }

    public void desligar() {
        this.ativo = false;
    }
}
