package TabelaHash;

public class Aluno {
    private int matricula; // Declara uma variável privada chamada matricula que representa o número de matrícula do aluno.

    public Aluno(){ // construtor padrão da classe Aluno, que não aceita argumentos.
        // Este construtor é chamado quando você cria uma instância da classe Aluno sem especificar uma matrícula.
        matricula = -1; // Inicializa a variável matricula com o valor -1. Isso é comumente usado para indicar que o aluno não possui uma matrícula válida.
        // Portanto, quando você cria um objeto Aluno sem especificar uma matrícula, a matrícula é definida como -1 por padrão.
    }

    public Aluno(int m) { //  Declara um construtor adicional da classe Aluno, que aceita um argumento inteiro "m".
        matricula = m; //  Inicializa a variável matricula com o valor fornecido como argumento.
        // Isso permite que você atribua uma matrícula específica a um objeto Aluno quando o cria.
    }

    public int getMatricula() { // Declara o método que permite obter o valor da matrícula de um objeto Aluno.
        return matricula; //  Retorna o valor armazenado na variável matricula, que representa o número de matrícula do aluno.
    }
}
