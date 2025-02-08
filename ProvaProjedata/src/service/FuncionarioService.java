package service;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public FuncionarioService() {
        inicializarFuncionarios();
    }

    private void inicializarFuncionarios() {
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public void removerFuncionario(String nome) {
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario f = iterator.next();
            if (f.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                break;
            }
        }
    }

    public void aplicarAumentoSalario() {
        for (Funcionario f : funcionarios) {
            BigDecimal novoSalario = f.getSalario().multiply(new BigDecimal("1.10"))
                    .setScale(2, RoundingMode.HALF_UP);
            f.setSalario(novoSalario);
        }
    }

    public String obterFuncionarioMaisVelho() {
        if (funcionarios.isEmpty()) return "Nenhum funcionário disponível.";

        Funcionario maisVelho = funcionarios.get(0);
        for (Funcionario f : funcionarios) {
            if (f.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = f;
            }
        }

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        return maisVelho.getNome() + " (" + idade + " anos)";
    }

    public BigDecimal calcularTotalSalarios() {
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }
        return total;
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        Map<String, List<Funcionario>> mapa = new HashMap<>();
        for (Funcionario f : funcionarios) {
            String funcao = f.getFuncao();
            if (!mapa.containsKey(funcao)) {
                mapa.put(funcao, new ArrayList<>());
            }
            mapa.get(funcao).add(f);
        }
        return mapa;
    }

    public List<Funcionario> filtrarAniversariantes() {
        List<Funcionario> aniversariantes = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            int mes = f.getDataNascimento().getMonthValue();
            if (mes == 10 || mes == 12) {
                aniversariantes.add(f);
            }
        }
        return aniversariantes;
    }

    public List<Funcionario> listarFuncionariosOrdenados() {
        List<Funcionario> ordenados = new ArrayList<>(funcionarios);
        Collections.sort(ordenados, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.getNome().compareTo(f2.getNome());
            }
        });
        return ordenados;
    }

    public Map<String, BigDecimal> calcularSalariosMinimos() {
        Map<String, BigDecimal> salariosMinimos = new HashMap<>();
        for (Funcionario f : funcionarios) {
            BigDecimal qtd = f.getSalario().divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            salariosMinimos.put(f.getNome(), qtd);
        }
        return salariosMinimos;
    }
}
