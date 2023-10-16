package TabelaHash;

public class Hash {
    private int max_positions; // variável privada chamada "max_positions" para armazenar o tamanho máximo da tabela hash.
    private int quant_itens; // variável privada chamada "quant_itens" para acompanhar o número atual de elementos na tabela hash.
    private int max_itens; // variável privada chamada "max_itens" para armazenar o número máximo de elementos permitidos na tabela hash.
    private Aluno[] structure; // array de objetos "Aluno" chamado "structure" que representará a tabela hash.

    public Hash(int vector_size, int max) { // construtor chamado quando você cria uma instância da classe "Hash"
        quant_itens = 0; //  Inicializa o número atual de itens na tabela hash como 0.
        max_itens = max; // nicializa o número máximo de itens com o valor fornecido como argumento.
        max_positions = vector_size; //  Inicializa o tamanho máximo da tabela hash com o valor fornecido como argumento.
        structure = new Aluno[vector_size]; // inicializa o array structure com o tamanho especificado, criando espaço para
        // armazenar os elementos da tabela hash.
    }

    public void insert(Aluno aluno) { // método insert, que permite inserir um aluno na tabela hash.
        int local = hashFunc(aluno); // Calcula a posição na tabela hash onde o aluno deve ser inserido usando a função de hash.
        structure[local] = aluno; // Insere o aluno na posição calculada na tabela hash.
        quant_itens++; // Incrementa o número de itens na tabela hash.
    }

    public void delete(Aluno aluno) { // método delete, que permite remover um aluno da tabela hash.
        int local = hashFunc(aluno); // Calcula a posição na tabela hash onde o aluno deve ser procurado usando a função de hash.
        if (structure[local].getMatricula() != -1) { // Verifica se a posição na tabela hash não está vazia
            // (o valor da matrícula não é -1) antes de tentar excluí-lo.
            structure[local] = new Aluno(-1); // Define o elemento na posição calculada como um novo aluno com matrícula -1, marcando-o como excluído.
            quant_itens--; // Decrementa o número de itens na tabela hash.
        }
    }

    public void search(Aluno aluno, boolean[] s) { // método search que permite buscar um aluno na tabela hash.
        int local = hashFunc(aluno); // Calcula a posição na tabela hash onde o aluno deve ser procurado usando a função de hash.
        Aluno aux = structure[local]; // Armazena o aluno na posição calculada em uma variável "aux".
        if (aluno.getMatricula() != aux.getMatricula()) { // Compara a matrícula do aluno buscado com a matrícula do aluno encontrado na tabela hash.
            s[0] = false; // Define o primeiro elemento do array s como false se o aluno não for encontrado.
        } else {
            s[0] = true; //  Define o primeiro elemento do array s como true se o aluno for encontrado e atualiza a referência aluno
            // para apontar para o aluno encontrado.
            aluno = aux;
        }
    }

    public void print() { //  Declara o método print, que imprime a tabela hash.
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_positions; i++) { // Inicia um loop que percorre todas as posições da tabela hash.
            if (structure[i] != null) { // Verifica se a posição na tabela hash não está vazia (não é nula) antes de tentar imprimir informações sobre o aluno.
                Aluno aluno = structure[i]; // Obtém o aluno na posição atual da tabela hash.
                System.out.println(i + ": Matrícula: " + aluno.getMatricula());
            } else{ // Se a posição estiver vazia, imprime "Vazio" para indicar que não há aluno nessa posição.
                System.out.println(i + ": Vazio");
            }
        }
    }

    private int hashFunc(Aluno aluno) { // método hashFunc, que calcula a posição na tabela hash com base na matrícula do aluno.
        return (aluno.getMatricula() % max_positions); // Calcula a posição usando a operação de módulo para garantir que a posição calculada esteja dentro
        // dos limites da tabela hash.
    } //

    public boolean isFull() {
        return (quant_itens == max_itens);
    }

    public int getSize() {
        return quant_itens;
    }
}
