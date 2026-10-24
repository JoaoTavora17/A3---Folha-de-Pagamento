import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Colaborador> lista = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE GESTÃO DE COLABORADORES ===");
            System.out.println("1 - Cadastrar Colaborador Padrão");
            System.out.println("2 - Cadastrar Colaborador comissionado");
            System.out.println("3 - Cadastrar Colaborador Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("5 - Exibir Resumo da Folha");
            System.out.println("0 - Sair do Programa");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro: Colaborador Padrão ---");
                    System.out.print("Nome: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    int matP = scanner.nextInt();

                    lista.add(new ColaboradorPadrao(nomeP, matP));
                    System.out.println("Colaborador Padrão cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Cadastro: Colaborador Comissionado ---");
                    System.out.print("Nome: ");
                    String nomeC = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    int matC = scanner.nextInt();
                    System.out.print("Valor das Vendas (R$): ");
                    double vendas = scanner.nextDouble();
                    System.out.print("Percentual de Comissão (%): ");
                    int comissaoPerc = scanner.nextInt();

                    ColaboradorComissionado cc = new ColaboradorComissionado(nomeC, matC);
                    cc.setValorVendas(vendas);
                    cc.setPercentualComissao(comissaoPerc);
                    lista.add(cc);
                    System.out.println("Colaborador Comissionado cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- Cadastro: Colaborador Produção ---");
                    System.out.print("Nome: ");
                    String nomePr = scanner.nextLine();
                    System.out.print("Matrícula: ");
                    int matPr = scanner.nextInt();
                    System.out.print("Quantidade de Peças: ");
                    int pecas = scanner.nextInt();
                    System.out.print("Valor por Peça (R$): ");
                    double valorPeca = scanner.nextDouble();

                    ColaboradorProducao cp = new ColaboradorProducao(nomePr, matPr);
                    cp.setQuantidadedePecas(pecas);
                    cp.setValorporPeca(valorPeca);
                    lista.add(cp);
                    System.out.println("Colaborador de Produção cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n=== 4 - GERAR FOLHA DE PAGAMENTO ===");
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum colaborador cadastrado.");
                    } else {
                        for (Colaborador c : lista) {
                            System.out.println("-----------------------------------");
                            System.out.println("Matrícula: " + c.getMatricula());
                            System.out.println("Nome: " + c.getNome());
                            System.out.println("Salário Base: R$ " + c.getSalarioBase());

                            double salarioFinal = c.getSalarioBase();

                            if (c instanceof ColaboradorPadrao) {
                                System.out.println("Tipo: Padrão");
                            }
                            else if (c instanceof ColaboradorComissionado) {
                                ColaboradorComissionado colabC = (ColaboradorComissionado) c;
                                System.out.println("Tipo: Comissionado");
                                System.out.println("Valor da Comissão: R$ " + colabC.calcularComissao());
                                salarioFinal = colabC.calcularSalarioFinal();
                            }
                            else if (c instanceof ColaboradorProducao) {
                                ColaboradorProducao colabP = (ColaboradorProducao) c;
                                System.out.println("Tipo: Produção");
                                System.out.println("Valor da Produtividade: R$ " + colabP.calcularProdutividade());
                                salarioFinal = colabP.calcularsalarioFinal();
                            }

                            System.out.println("Salário Final: R$ " + salarioFinal);
                        }
                        System.out.println("-----------------------------------");
                    }
                    break;

                case 5:
                    System.out.println("\n=== 5 - EXIBIR RESUMO DA FOLHA ===");
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum colaborador cadastrado.");
                    } else {
                        int totalColaboradores = lista.size();
                        double somaTotal = calcularTotalFolha(lista);
                        double mediaSalarial = calcularMediaSalarial(lista);

                        System.out.println("-----------------------------------");
                        System.out.println("Quantidade total de colaboradores: " + totalColaboradores);
                        System.out.println("Soma total da folha de pagamento: R$ " + String.format("%.2f", somaTotal));
                        System.out.println("Média salarial dos colaboradores: R$ " + String.format("%.2f", mediaSalarial));
                        System.out.println("-----------------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Métodos auxiliares colocados no final da classe para evitar conflitos de sintaxe
    public static double calcularTotalFolha(ArrayList<Colaborador> lista) {
        double totalGeral = 0;
        for (Colaborador c : lista) {
            if (c instanceof ColaboradorPadrao) {
                totalGeral += c.getSalarioBase();
            } else if (c instanceof ColaboradorComissionado) {
                totalGeral += ((ColaboradorComissionado) c).calcularSalarioFinal();
            } else if (c instanceof ColaboradorProducao) {
                totalGeral += ((ColaboradorProducao) c).calcularsalarioFinal();
            }
        }
        return totalGeral;
    }

    public static double calcularMediaSalarial(ArrayList<Colaborador> lista) {
        if (lista.isEmpty()) {
            return 0;
        }
        return calcularTotalFolha(lista) / lista.size();
    }
}