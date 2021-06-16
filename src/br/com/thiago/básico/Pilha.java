package br.com.thiago.básico;

import java.util.Scanner;

public class Pilha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean acabou = false;
        int qtdElementos = 0;
        Integer[] arr = new Integer[10];

        while (!acabou) {
            switch (menu(input)) {
                case 1:
                    arr = push(input, arr, qtdElementos);
                    qtdElementos++;
                    break;
                case 2:
                    mostrarPilha(arr);
                    break;
                case 3:
                    pop(arr, qtdElementos);
                    qtdElementos--;
                    break;
                case 4:
                    acabou = true;
                    break;
                default:
                    System.out.println("Informe uma opção valida");
                    break;
            }
        }
    }

    private static int menu(Scanner input) {
        int opc;
        do {
            System.out.print(
                    "1 - Adicionar na pilha\n" +
                            "2 - Mostrar a pilha\n" +
                            "3 - Remover da pilha\n" +
                            "4 - sair\n\n" +
                            "Entre com a opção desejada: ");
            opc = input.nextInt();
        } while (opc < 1 || opc > 4);
        return opc;
    }

    private static Integer[] push(Scanner input, Integer[] arr, int qtdElementos) {
        if (qtdElementos == arr.length) {
            Integer[] temp = arr;
            arr = new Integer[qtdElementos << 1];
            System.arraycopy(temp, 0, arr, 0, qtdElementos);
        }
        System.out.print("\nInforme o próximo da pilha: ");
        int n = input.nextInt();
        arr[qtdElementos] = n;
        return arr;
    }

    private static void mostrarPilha(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {
                System.out.println(" | " + arr[i] + " | ");
            }
        }
        System.out.println();
    }

    private static void pop(Integer[] arr, int qtdElementos) {
        int temp = arr[qtdElementos-1];
        arr[qtdElementos - 1] = null;
        System.out.println("Valor retirado da pilha: " + temp);
        System.out.println("Nova pilha:\n");
        mostrarPilha(arr);
    }

}
