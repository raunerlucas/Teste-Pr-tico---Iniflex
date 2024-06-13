package com.exemplo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Relatorio {

    static String getSalarioFormatado(BigDecimal salario) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(salario);
    }

    static Collection<Funcionario> cadatraFuncionariosTabela() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", "18/10/2000", new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente"));
        return funcionarios;
    }

    static void agrupaFuncionariosFuncao(List<Funcionario> funcionarios) {
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("\nFunção: " + funcao);
            listaFuncionarios.forEach(System.out::println);
        });
    }

    static void numSalariosMinFunico(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_EVEN);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        });
    }

    static void funcionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("Funcionário com a maior idade: " + funcionarioMaisVelho.getNome() + ", Idade: " + idade);
        } else {
            System.out.println("Não há funcionários cadastrados.");
        }
    }

    static void totalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários dos funcionários: " + getSalarioFormatado(totalSalarios));
    }

    static void funcionariosFazemAniversaioEm(Integer[] meses,List<Funcionario> funcionarios) {
        for (Integer mes : meses) {
            funcionarios.stream()
                    .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == mes)
                    .forEach(System.out::println);
        }
    }
}
