package TabelaHash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa gerador de Hash!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho da Hash:");
        int vector_size = scanner.nextInt();
        System.out.println("Digite o número máximo de elementos:");
        int max = scanner.nextInt();
        System.out.println("O fator de carga e: " + (float) max / (float) vector_size);
        Hash alunohash = new Hash(vector_size, max);
        int option;
        int matricula;
        do {
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
                if (alunohash.insert(aluno)) {
                    System.out.println("Aluno inserido com sucesso.");
                } else {
                    System.out.println("Falha ao inserir o aluno.");
                }
            } else if (option == 2) {
                System.out.println("Qual é a matrícula do aluno a ser removida?");
                matricula = scanner.nextInt();
                Aluno aluno = new Aluno(matricula);
                if (alunohash.delete(aluno)) {
                    System.out.println("Aluno removido com sucesso.");
                } else {
                    System.out.println("Falha ao remover o aluno ou aluno não encontrado.");
                }
            }
            if (option == 3) {
                System.out.println("Qual é a matrícula do aluno a ser buscada?");
                matricula = scanner.nextInt();
                Aluno alunoToSearch = new Aluno(matricula);
                Aluno foundAluno = alunohash.search(alunoToSearch);
                if (foundAluno != null) {
                    int chave = alunohash.getAlunoKey(foundAluno);
                    System.out.println("Aluno encontrado:");
                    System.out.println("Matrícula: " + foundAluno.getMatricula());
                    System.out.println("Chave: " + chave);
                } else {
                    System.out.println("Aluno não encontrado!");
                }
            }
            else if (option == 4) {
                alunohash.print();
            }
        } while (option != 0);
        scanner.close();
    }
}