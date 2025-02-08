package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getSalarioFormatado() {
        return String.format(Locale.forLanguageTag("pt-BR"), "%,.2f", salario);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +
                " | Data: " + getDataFormatada() +
                " | Salário: R$ " + getSalarioFormatado() +
                " | Função: " + funcao;
    }
}
