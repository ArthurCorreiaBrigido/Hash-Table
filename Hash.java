package TabelaHash;

public class Hash {
    private int max_positions;
    private int quant_itens;
    private int max_itens;
    private HashNode[] structure;
    private final int MAX_TRIES = 5;

    public Hash(int vector_size, int max) {
        quant_itens = 0;
        max_itens = max;
        max_positions = vector_size;
        structure = new HashNode[vector_size * 2];
    }

    public boolean insert(Aluno aluno) {
        int key = hashFunc(aluno);
        for (int i = 0; i < MAX_TRIES; i++) {
            if (structure[key] == null) {
                structure[key] = new HashNode(key, aluno);
                return true;
            }
            key = (key + 1) % max_positions;
        }
        return insertInBucket(aluno, hashFunc(aluno));
    }


    private boolean insertInBucket(Aluno aluno, int key) {
        if (structure[key] == null) {
            structure[key] = new HashNode(key, aluno);
            return true;
        }
        HashNode currentNode = structure[key];
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new HashNode(key, aluno));
        return true;
    }


    public Aluno search(int matricula) {
        int key = hashFunc(new Aluno(matricula));
        for (int i = 0; i < MAX_TRIES; i++) {
            if (structure[key] != null && structure[key].getValue().getMatricula() == matricula) {
                return structure[key].getValue();
            }
            key = (key + 1) % max_positions;
        }
        return searchInBucket(matricula);
    }

    private Aluno searchInBucket(int matricula) {
        int key = hashFunc(new Aluno(matricula));
        HashNode currentNode = structure[key];
        while (currentNode != null) {
            if (currentNode.getValue().getMatricula() == matricula) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public boolean delete(Aluno aluno) {
        int key = hashFunc(aluno);
        for (int i = 0; i < MAX_TRIES; i++) {
            if (structure[key] != null && structure[key].getValue().getMatricula() == aluno.getMatricula()) {
                structure[key] = null;
                return true;
            }
            key = (key + 1) % max_positions;
        }
        return deleteInBucket(aluno, hashFunc(aluno));
    }

    private boolean deleteInBucket(Aluno aluno, int key) {
        if (structure[key] == null) {
            return false;
        }
        if (structure[key].getValue().getMatricula() == aluno.getMatricula()) {
            structure[key] = structure[key].getNext();
            return true;
        }
        HashNode currentNode = structure[key];
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getValue().getMatricula() == aluno.getMatricula()) {
                currentNode.setNext(currentNode.getNext().getNext());
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void print() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < max_positions; ++i) {
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

}
