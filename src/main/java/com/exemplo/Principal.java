package com.exemplo;

import java.math.BigDecimal;
import java.util.*;

import static com.exemplo.Relatorio.*;

public class Principal {
    public static void main(String[] args) {
        /**
         * 3.1 – Inserir todos os funcionários.
         */
        List<Funcionario> funcionarios = new ArrayList<>(cadatraFuncionariosTabela());

        System.out.println("\n3.2 – Remover o funcionário “João” da lista.");
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        System.out.println("\n3.3 – Imprimir os funcionários.");
        funcionarios.forEach(System.out::println);

        System.out.println("\n3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
        funcionarios.forEach(funcionario -> funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.1"))));


        System.out.println("\n3.5 – Agrupar os funcionários por função em um MAP sendo a chave a “função” e o valor a “lista de funcionários”."
                + " 3.6 – Imprimir os funcionários, agrupados por função.");
        agrupaFuncionariosFuncao(funcionarios);


        System.out.println("\n3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        System.out.println("Funcionários que fazem aniversário no mês 10 e 12:");
        funcionariosFazemAniversaioEm(new Integer[]{10,12},funcionarios);


        System.out.println("\n3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        funcionarioMaisVelho(funcionarios);

        System.out.println("\n3.10 – Imprimir a lista de funcionários por ordem alfabética.");
        System.out.println("Lista de funcionários por ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);


        System.out.println("\n3.11 – Imprimir o total dos salários dos funcionários.");
        totalSalarios(funcionarios);

        System.out.println("\n3.12 – Imprimir quantos salários mínimos ganha cada funcionário.");
        numSalariosMinFunico(funcionarios);
    }


}
