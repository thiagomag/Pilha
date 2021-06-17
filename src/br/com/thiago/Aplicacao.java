package br.com.thiago;

import br.com.thiago.estruturas.EstruturaDados;
import br.com.thiago.estruturas.Pilha;
import br.com.thiago.exceptions.FilaVaziaException;
import br.com.thiago.exceptions.IndiceInexistenteException;
import br.com.thiago.exceptions.PessoaNaoEcontradaException;
import br.com.thiago.exceptions.TipoDeRemocaoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplicacao {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean continua = true;
        Pilha pilha = new Pilha();
        dadosIniciais(pilha);

        while (continua) {
            switch (menu(input)) {
                case 1:
                    System.out.println("Qual o nome da pessoa?");
                    input.nextLine();
                    String nome = input.nextLine();
                    System.out.println("Qual a idade da pessoa?");
                    String idade = input.nextLine();
                    pilha.adicionar(new Pessoa(nome, idade));
                    break;
                case 2:
                    pilha.listarTodos();
                    break;
                case 3:
                    try {
                        System.out.println("Qual o índice da pessoa que deseja mostrar?");
                        pilha.getPessoa(input.nextInt());
                    } catch (IndiceInexistenteException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Qual o nome da pessoa que deseja mostrar?");
                        input.nextLine();
                        pilha.buscar(input.nextLine());
                    } catch (PessoaNaoEcontradaException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        pilha.remover();
                    } catch (FilaVaziaException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        Pessoa pessoa = new Pessoa();
                        pilha.remover(pessoa);
                    } catch (TipoDeRemocaoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        int index = 0;
                        pilha.remover(index);
                    } catch (TipoDeRemocaoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 8:
                    continua = false;
                    break;
                default:
                    System.out.println("Informe uma opção valida");
                    break;
            }
        }
    }

    private static int menu(Scanner input) {
        int opcao;
        do {
            System.out.println(
                    "1 - Adicionar na pilha\n" +
                            "2 - Mostrar a pilha\n" +
                            "3 - Mostrar a pessoa da pilha por índice\n" +
                            "4 - Mostrar a pessoa da pilha por nome\n" +
                            "5 - Remover da pilha\n" +
                            "6 - Remover pelo nome\n" +
                            "7 - Remover por índice\n" +
                            "8 - Sair\n" +
                            "Entre com a opção desejada");
            opcao = input.nextInt();
        } while (opcao < 1 || opcao > 8);
        return opcao;
    }

    private static void dadosIniciais(EstruturaDados estruturaDados) throws IOException {
        Path path = Paths.get("dados.txt");
        try (Stream<String> stream = Files.lines(path)) {
            List<String> lines = stream.collect(Collectors.toUnmodifiableList());
            for (int i = 0; i < lines.size(); i += 2) {
                String nome = lines.get(i);
                String idade = lines.get(i + 1);
                estruturaDados.adicionar(new Pessoa(nome, idade));
            }
        }
    }
}
