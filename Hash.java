package TabelaHash;

public class Hash {
    private final int max_positions;
    private int quant_itens;
    private final int max_itens;
    private final HashNode[] structure;

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
        int originalKey = key;
        int attempts = 0;
        while (!isFull() && attempts < max_positions) {
            if (structure[key] == null) {
                structure[key] = new HashNode(key, aluno);
                return true;
            }
            key = (key + 1) % max_positions;
            attempts++;
        }
        return insertInBucket(aluno, originalKey);
    }


    private boolean insertInBucket(Aluno aluno, int key) {
        HashNode currentNode = structure[key];
        HashNode previousNode = null;

        while (currentNode != null) {
            if (currentNode.getKey() == key) {
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode == null) {
            return false;
        }

        previousNode.setNext(new HashNode(key, aluno));
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
        int originalKey = key;
        int attempts = 0;
        while (attempts < max_positions) {
            if (structure[key] != null && structure[key].getKey() == key) {
                structure[key] = null;
                return true;
            }
            key = (key + 1) % max_positions;
            attempts++;
        }
        return deleteInBucket(originalKey);
    }

    private boolean deleteInBucket(int key) {
        HashNode currentNode = structure[key];
        HashNode previousNode = null;

        while (currentNode != null) {
            if (currentNode.getKey() == key) {
                if (previousNode == null) {
                    structure[key] = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
                return true;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public Aluno search(Aluno aluno) {
        int key = searchKey(aluno);
        if (key != -1) {
            return structure[key].getValue();
        }
        return null;
    }


    private int searchKey(Aluno aluno) {
        int key = hashFunc(aluno);
        if (quant_itens == structure.length || key >= structure.length) {
            return -1;
        }
        if (structure[key] != null && structure[key].getValue().getMatricula() == aluno.getMatricula()) {
            return key;
        }
        int probeKey = (key + 1) % max_positions;
        while (probeKey != key) {
            if (structure[probeKey] != null && structure[probeKey].getValue().getMatricula() == aluno.getMatricula()) {
                return probeKey;
            }
            probeKey = (probeKey + 1) % max_positions;
        }
        return -1;
    }


    private int searchKey(int key) {
        int originalKey = key;
        int attempts = 0;
        while (attempts < max_positions) {
            if (structure[key] != null && structure[key].getKey() == key) {
                return key;
            }
            key = (key + 1) % max_positions;
            attempts++;
        }
        if (searchInBucket(originalKey) != -1) {
            return originalKey;
        }
        return -1;
    }


    private int searchInBucket(int key) {
        HashNode currentNode = structure[key];
        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                if (currentNode.getNext().getKey() == key) {
                    return key;
                }
                currentNode = currentNode.getNext();
            }
        }
        return -1;
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

    public boolean isFull() {
        return (quant_itens == max_itens);
    }

    public int getAlunoKey(Aluno aluno) {
        return searchKey(aluno);
    }

}