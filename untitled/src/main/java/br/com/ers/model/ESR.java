package br.com.ers.model;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ESR {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaERS sistema = new SistemaERS();
        int escolha = 0;

        System.out.println("Bem-vindo ao Sistema ERS!");

        while (escolha != 4) {
            try {
                System.out.println("\n---- Menu Principal ----");
                System.out.println("1 - Gerenciar Colaboradores");
                System.out.println("2 - Gerenciar Recursos");
                System.out.println("3 - Gerenciar Alocações");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");

                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1 -> {
                        System.out.println("\n---- Opções de Colaborador ----");
                        System.out.println("1 - Ver colaboradores");
                        System.out.println("2 - Adicionar colaborador");
                        System.out.println("3 - Remover colaborador");
                        System.out.print("Escolha: ");
                        int escolhaColab = scanner.nextInt();
                        scanner.nextLine();

                        switch (escolhaColab) {
                            // Display all collaborators in terminal
                            case 1 -> sistema.mostrarTodosColaboradores();
                            case 2 -> {
                                System.out.println("\n---- Adicionar Colaborador ----");
                                System.out.print("ID do colaborador: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();

                                System.out.print("Cargo: ");
                                String cargo = scanner.nextLine();

                                System.out.print("Salário: ");
                                double salario = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.println("O colaborador vai trabalhar de home office? ");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");
                                int homeOffice = scanner.nextInt();

                                // Add the new collaborator with the user input
                                Colaborador novoColaborador = new Colaborador(id, nome, cargo, salario);

                                if(homeOffice == 1){
                                    novoColaborador.setHomeOffice(true);
                                }

                                sistema.cadastrarColaborador(novoColaborador);
                                System.out.println("Colaborador cadastrado com sucesso!");
                            }
                            case 3 -> {
                                System.out.println("\n---- Remover Colaborador ----");
                                System.out.print("Qual o nome do colaborador a remover? ");
                                String nomeRemover = scanner.nextLine();

                                // Search collaborator by name and remove it from the list
                                Colaborador c = sistema.buscarColaborador(nomeRemover);
                                if (c != null) {
                                    sistema.desligarColaborador(c);
                                    System.out.println("Colaborador removido com sucesso!");
                                } else {
                                    System.out.println("Colaborador não encontrado.");
                                }
                            }
                            default -> System.out.println("Opção inválida de colaborador.");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n---- Opções de Recurso ----");
                        System.out.println("1 - Ver recursos");
                        System.out.println("2 - Adicionar recurso");
                        System.out.println("3 - Remover recurso");
                        System.out.print("Escolha: ");
                        int escolhaRec = scanner.nextInt();
                        scanner.nextLine();

                        switch (escolhaRec) {
                            case 1 -> sistema.mostrarTodosRecursos();
                            case 2 -> {
                                System.out.println("\n---- Adicionar Recurso ----");
                                System.out.print("ID do recurso: ");
                                int id = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nome do recurso: ");
                                String nome = scanner.nextLine();

                                System.out.print("Categoria: ");
                                String categoria = scanner.nextLine();

                                System.out.print("Valor Estimado: ");
                                double valor = scanner.nextDouble();

                                System.out.println("O recurso é portátil?");
                                System.out.println("1 - Sim");
                                System.out.println("2 - Não");
                                int portatil = scanner.nextInt();
                                scanner.nextLine();

                                Recurso novoRecurso = new Recurso(id, nome, categoria, valor);

                                if(portatil == 1){
                                    novoRecurso.setPortatil(true);
                                }

                                sistema.adicionarRecurso(novoRecurso);
                                System.out.println("Recurso adicionado com sucesso!");
                            }
                            case 3 -> {
                                System.out.println("\n---- Remover Recurso ----");
                                System.out.print("Qual o nome do recurso a remover? ");
                                String nomeRemover = scanner.nextLine();

                                Recurso r = sistema.buscarRecurso(nomeRemover);
                                if (r != null) {
                                    sistema.removerRecurso(r);
                                    System.out.println("Recurso removido com sucesso!");
                                } else {
                                    System.out.println("Recurso não encontrado.");
                                }
                            }
                            default -> System.out.println("Opção inválida de recurso.");
                        }
                    }
                    case 3 -> {
                        System.out.println("\n---- Opções de Alocação ----");
                        System.out.println("1 - Ver alocações");
                        System.out.println("2 - Adicionar alocação");
                        System.out.println("3 - Remover alocação");
                        System.out.print("Escolha: ");
                        int escolhaAloc = scanner.nextInt();
                        scanner.nextLine();

                        switch (escolhaAloc) {
                            case 1 -> sistema.mostrarTodasLocacoes();
                            case 2 -> {
                                System.out.println("\n---- Adicionar Alocação ----");
                                System.out.print("Id do Colaborador: ");
                                int idColab = scanner.nextInt();
                                scanner.nextLine();
                                Colaborador c = sistema.buscarColaborador(idColab);

                                System.out.print("Id do Recurso: ");
                                int idRec = scanner.nextInt();
                                scanner.nextLine();
                                Recurso r = sistema.buscarRecurso(idRec);

                                // Checks if the variables aren't empty
                                if (c != null && r != null) {
                                    if (r.podeSerAlocado() && c.isHomeOffice() == r.isPortatil()) {
                                        System.out.print("Observação da alocação: ");
                                        String obs = scanner.nextLine();

                                        // Add the "alocacao" to the list
                                        Alocacao novaAlocacao = new Alocacao(c.getId(), r.getId(), new Date(), obs);
                                        sistema.alocarRecurso(novaAlocacao);
                                        System.out.println("Alocação realizada com sucesso!");
                                    } else {
                                        System.out.println("O recurso não pode ser alocado.");
                                    }
                                } else {
                                    System.out.println("Colaborador ou Recurso não encontrado no sistema.");
                                }
                            }
                            case 3 -> {
                                System.out.println("\n---- Remover Alocação ----");
                                System.out.print("ID numérico do Colaborador: ");
                                int idC = scanner.nextInt();

                                System.out.print("ID numérico do Recurso: ");
                                int idR = scanner.nextInt();
                                scanner.nextLine();

                                // Remove an alocacao object from array
                                Alocacao a = sistema.buscarAlocacao(idC, idR);
                                if (a != null) {
                                    sistema.devolverLocacao(a);
                                    System.out.println("Alocação removida com sucesso!");
                                } else {
                                    System.out.println("Alocação não encontrada.");
                                }
                            }
                            default -> System.out.println("Opção inválida de alocação.");
                        }
                    }
                    case 4 -> System.out.println("Desligando sistema...");
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }

                // Trigger if the input has a wrong type
            } catch (InputMismatchException e) {
                System.out.println("\n[ERRO] Entrada inválida!");
                scanner.nextLine();
                // Trigger if any other type of error happens
            } catch (Exception e) {
                System.out.println("\n[ERRO] Ocorreu um erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
