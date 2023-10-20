package TabelaHash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa gerador de Hash!");

        Scanner scanner = new Scanner(System.in); // objeto do tipo "Scanner" chamado "scanner" para ler a entrada do usuário a partir do terminal.

        System.out.println("Digite o tamanho da Hash:");
        int vector_size = scanner.nextInt(); //  objeto "scanner" para ler um número inteiro digitado pelo usuário e atribui-se o valor à variável "vector_size",
        // que representa o tamanho da tabela hash.

        System.out.println("Digite o número máximo de elementos:");
        int max = scanner.nextInt(); // Lê um número inteiro digitado pelo usuário e atribui o valor à variável max, que representa o número máximo de elementos.

        System.out.println("O fator de carga e: " + (float) max / (float) vector_size);

        Hash alunohash = new Hash(vector_size, max);  // Cria um objeto da classe "Hash" chamado "alunohash", usando os valores de "vector_size" e "max" para
        // inicializar a tabela hash.

        int option; // Declara uma variável option para armazenar a opção escolhida pelo usuário no menu.
        int matricula; // Declara uma variável matricula para armazenar a matrícula do aluno.

        do { // Início de um loop do-while que continuará até que a opção escolhida seja 0 (para sair).
            System.out.println("Digite 0 para parar o algoritmo!");
            System.out.println("Digite 1 para inserir um elemento!");
            System.out.println("Digite 2 para remover um elemento!");
            System.out.println("Digite 3 para buscar um elemento!");
            System.out.println("Digite 4 para imprimir a Hash!");
            option = scanner.nextInt(); // Lê a opção escolhida pelo usuário.

            if (option == 1) {
                System.out.println("Qual e a matrícula do aluno?");
                matricula = scanner.nextInt();
                Aluno aluno = new Aluno(matricula);
                alunohash.insert(aluno);
            } else if (option == 2) {
                System.out.println("Qual é a matrícula do aluno a ser removida?");
                matricula = scanner.nextInt();
                Aluno aluno = new Aluno(matricula);
                alunohash.delete(aluno);
            } else if (option == 3) {
                System.out.println("Qual é a matrícula do aluno a ser buscada?");
                matricula = scanner.nextInt();
                Aluno aluno = new Aluno(matricula);
                int chave = alunohash.search(aluno);
                if (chave != -1) {
                    System.out.println("Aluno encontrado:");
                    System.out.println("Matrícula: " + aluno.getMatricula());
                    System.out.println("Chave: " + chave);
                } else {
                    System.out.println("Aluno não encontrado!");
                }
            } else if (option == 4) {
                alunohash.print();
            }

        } while (option != 0); // Fecha o loop do-while, que continuará até que a opção escolhida seja 0 (para sair).

        scanner.close(); // Fecha o objeto Scanner para liberar recursos após a conclusão do programa.
    }
}