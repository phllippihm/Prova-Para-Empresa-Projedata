package controller;

import model.Funcionario;
import service.FuncionarioService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FuncionarioController {
    private FuncionarioService funcionarioService = new FuncionarioService();

    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    public void removerFuncionario(String nome) {
        funcionarioService.removerFuncionario(nome);
    }

    public void aplicarAumentoSalario() {
        funcionarioService.aplicarAumentoSalario();
    }

    public String obterFuncionarioMaisVelho() {
        return funcionarioService.obterFuncionarioMaisVelho();
    }

    public BigDecimal calcularTotalSalarios() {
        return funcionarioService.calcularTotalSalarios();
    }

    public List<Funcionario> listarFuncionariosOrdenados() {
        return funcionarioService.listarFuncionariosOrdenados();
    }

    public List<Funcionario> filtrarAniversariantes() {
        return funcionarioService.filtrarAniversariantes();
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarioService.agruparPorFuncao();
    }

    public Map<String, BigDecimal> calcularSalariosMinimos() {
        return funcionarioService.calcularSalariosMinimos();
    }
}
