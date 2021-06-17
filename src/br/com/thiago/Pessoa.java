package br.com.thiago;

public class Pessoa {
    String nome;
    String idade;

    public Pessoa() {
    }

    public Pessoa(String nome, String idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                ", idade: " + idade;
    }
}
