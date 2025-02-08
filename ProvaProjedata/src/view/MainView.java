package view;

import controller.FuncionarioController;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private FuncionarioController controller = new FuncionarioController();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        while (true) {
            System.out.println("\n========================================");
            System.out.println("         GESTÃO DE FUNCIONÁRIOS        ");
            System.out.println("========================================");
            System.out.println("  1 - Listar Funcionários");
            System.out.println("  2 - Remover João");
            System.out.println("  3 - Aumentar Salário em 10%");
            System.out.println("  4 - Funcionário Mais Velho");
            System.out.println("  5 - Total de Salários");
            System.out.println("  6 - Funcionários por Ordem Alfabética");
            System.out.println("  7 - Aniversariantes (Outubro e Dezembro)");
            System.out.println("  8 - Funcionários por Função");
            System.out.println("  9 - Salários Mínimos por Funcionário");
            System.out.println(" 10 - Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número entre 1 e 10.");
                scanner.next(); 
                continue;
            }

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer do Scanner

            switch (opcao) {
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    removerJoao();
                    break;
                case 3:
                    aumentarSalario();
                    break;
                case 4:
                    exibirFuncionarioMaisVelho();
                    break;
                case 5:
                    calcularTotalSalarios();
                    break;
                case 6:
                    listarFuncionariosOrdenados();
                    break;
                case 7:
                    filtrarAniversariantes();
                    break;
                case 8:
                    imprimirFuncionariosPorFuncao();
                    break;
                case 9:
                    exibirSalariosMinimos();
                    break;
                case 10:
                    System.out.println("\nSaindo do sistema... Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida! Escolha entre 1 e 10.");
            }
        }
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = controller.listarFuncionarios();
        System.out.println("\n===== LISTA DE FUNCIONÁRIOS =====");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    private void removerJoao() {
        controller.removerFuncionario("João");
        System.out.println("João foi removido com sucesso!");
    }

    private void aumentarSalario() {
        controller.aplicarAumentoSalario();
        System.out.println("Salários aumentados em 10%!");
    }

    private void exibirFuncionarioMaisVelho() {
        System.out.println("\nFuncionário mais velho: " + controller.obterFuncionarioMaisVelho());
    }

    private void calcularTotalSalarios() {
        BigDecimal totalSalarios = controller.calcularTotalSalarios();
        System.out.println("\nTotal de salários: R$ " + totalSalarios);
    }

    private void listarFuncionariosOrdenados() {
        List<Funcionario> ordenados = controller.listarFuncionariosOrdenados();
        System.out.println("\n===== FUNCIONÁRIOS EM ORDEM ALFABÉTICA =====");
        for (Funcionario f : ordenados) {
            System.out.println(f);
        }
    }

    private void filtrarAniversariantes() {
        List<Funcionario> aniversariantes = controller.filtrarAniversariantes();
        System.out.println("\n===== ANIVERSARIANTES (OUT/DEZ) =====");
        for (Funcionario f : aniversariantes) {
            System.out.println(f);
        }
    }

    private void imprimirFuncionariosPorFuncao() {
        Map<String, List<Funcionario>> grupos = controller.agruparPorFuncao();
        System.out.println("\n===== FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO =====");
        for (Map.Entry<String, List<Funcionario>> entry : grupos.entrySet()) {
            System.out.println("\nFunção: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println(" - " + f.getNome());
            }
        }
    }

    private void exibirSalariosMinimos() {
        Map<String, BigDecimal> salariosMinimos = controller.calcularSalariosMinimos();
        System.out.println("\n===== SALÁRIOS MÍNIMOS POR FUNCIONÁRIO =====");
        for (Map.Entry<String, BigDecimal> entry : salariosMinimos.entrySet()) {
            System.out.println(entry.getKey() + " recebe " + entry.getValue() + " salários mínimos.");
        }
    }
}
