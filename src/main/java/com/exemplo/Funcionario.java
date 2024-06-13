package com.exemplo;

import java.math.BigDecimal;
import java.util.Objects;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getSalario(), that.getSalario()) && Objects.equals(getFuncao(), that.getFuncao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalario(), getFuncao());
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        if (salario.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        if (funcao == null || funcao.trim().isEmpty() || funcao.matches(".*\\d.*"))
            throw new IllegalArgumentException("Função não pode ser vazia ou ter numeros.");
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Salário: " + Relatorio.getSalarioFormatado(salario) + " | Função: " + funcao;
    }
}
