package TabelaHash;

public class Hash {
    private int max_positions;
    private int quant_itens;
    private int max_itens;
    private HashNode[] structure;

    public Hash(int vector_size, int max) {
        quant_itens = 0;
        max_itens = max;
        max_positions = vector_size;
        structure = new HashNode[vector_size * 2];
    }

    public boolean insert(Aluno aluno) {
        return insert(aluno, hashFunc(aluno));
    }

    private boolean insert(Aluno aluno, int key) {
        if (isFull()) {
            return false;
        }
        while (structure[key] != null) {
            key = (key + 1) % max_positions;
        }
        structure[key] = new HashNode(key, aluno);
        quant_itens++;
        return true;
    }

    public boolean delete(Aluno aluno) {
        if (delete(hashFunc(aluno))) {
            quant_itens--;
            return true;
        }
        return false;
    }

    private boolean delete(int key) {
        if (key >= structure.length) {
            return false;
        }
        HashNode currentNode = structure[key];
        HashNode previousNode = null;
        while (currentNode != null && currentNode.getKey() != key) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) { // Chave não encontrada.
            return false;
        }
        if (previousNode == null) { // Chave está no primeiro nó.
            structure[key] = currentNode.getNext();
        } else {
            previousNode.setNext(currentNode.getNext());
        }
        quant_itens--; // Decrementa a quantidade de itens.
        return true;
    }

    public int search(Aluno aluno) {
        return search(hashFunc(aluno));
    }

    private int search(int key) {
        int initialKey = key;
        while (structure[key] != null) {
            HashNode currentNode = structure[key];
            while (currentNode != null) {
                if (currentNode.getKey() == key) {
                    return key;
                }
                currentNode = currentNode.getNext();
            }
            key = (key + 1) % max_positions;
            if (key == initialKey) { // Já deu a volta completa na tabela.
                break;
            }
        }
        return -1; // Chave não encontrada.
    }

    public void print() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < structure.length; ++i) {
            if (structure[i] != null) {
                System.out.println(i + ": Matrícula: " + structure[i].getValue().getMatricula());
            } else {
                System.out.println(i + ": Vazio");
            }
        }
    }

    private int hashFunc(Aluno aluno) {
        return (aluno.getMatricula() % max_positions);

    }

    public boolean isFull() {
        return (quant_itens == max_itens);
    }

}