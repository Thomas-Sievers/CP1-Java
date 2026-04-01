package br.com.ers.model;

import java.util.ArrayList;
import java.util.List;

public class SistemaERS {
    private List<Colaborador> colaboradores = new ArrayList<>();
    private List<Recurso> recursos = new ArrayList<>();
    private List<Alocacao> alocacoes = new ArrayList<>();

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    public List<Alocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(List<Alocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }

    public void cadastrarColaborador(Colaborador colaborador){
        colaboradores.add(colaborador);
    }

    public void desligarColaborador(Colaborador colaborador){
        colaboradores.remove(colaborador);
    }

    public void adicionarRecurso(Recurso recurso){
        recursos.add(recurso);
    }

    public void removerRecurso(Recurso recurso){
        recursos.remove(recurso);
    }

    public void alocarRecurso(Alocacao alocacao){
        alocacoes.add(alocacao);
    }

    public void devolverLocacao(Alocacao alocacao){
        alocacoes.remove(alocacao);
    }

    public void mostrarTodosColaboradores(){
        for (Colaborador colaborador : colaboradores){
            System.out.printf("ID: %d | Nome: %s | Cargo: %s | Salário: R$ %.2f | Ativo: %s%n",
                    colaborador.getId(), colaborador.getNome(), colaborador.getCargo(), colaborador.getSalario(), (colaborador.isAtivo() ? "Sim" : "Não"));
        }
    }

    public void mostrarTodosRecursos(){
        for (Recurso recurso : recursos){
            System.out.println("id: " + recurso.getId() +
                    "| Recurso: " + recurso.getNomeDoRecurso() +
                    "| Categoria: " + recurso.getCategoria() +
                    "| Disponível: " + recurso.isDisponivel() +
                    "| Valor Estimado: " + recurso.getValorEstimado());
        }
    }

    public void mostrarTodasLocacoes(){
        for (Alocacao alocacao : alocacoes){
             System.out.println("Id do Colaborador: " + alocacao.getColaboradorId() +
             "| Id do Recurso: " + alocacao.getRecursoId() +
             "| Data: " + alocacao.getData() +
             "| Observação: " + alocacao.getObservacao());
        }
    }

    public Colaborador buscarColaborador(int id){
        for(Colaborador c : colaboradores){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public Colaborador buscarColaborador(String nome){
        for(Colaborador c : colaboradores){
            if(c.getNome().trim().equalsIgnoreCase(nome.trim())){
                return c;
            }
        }
        return null;
    }

    public Recurso buscarRecurso(int id){
        for(Recurso r : recursos){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public Recurso buscarRecurso(String nome){
        for(Recurso r : recursos){
            if(r.getNomeDoRecurso().trim().equalsIgnoreCase(nome.trim())){
                return r;
            }
        }
        return null;
    }

    public Alocacao buscarAlocacao(int colaboradorId, int recursoId){
        int colaborador = 0;
        int recurso = 0;

        for(Colaborador c : colaboradores){
            if(c.getId() == colaboradorId){
                colaborador = c.getId();
            }
        }

        for (Recurso r : recursos){
            if(r.getId() == recursoId){
                recurso = r.getId();
            }
        }

        for (Alocacao a : alocacoes){
            if(a.getColaboradorId() == colaborador && a.getRecursoId() == recurso){
                return a;
            }
        }
        return null;
    }
}