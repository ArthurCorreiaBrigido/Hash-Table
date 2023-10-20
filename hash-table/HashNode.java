package TabelaHash;

public class HashNode {
    private int key;
    private Aluno value;
    private HashNode next;

    public HashNode(int key, Aluno value, HashNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public HashNode(int key, Aluno value){
        this(key ,value, null);
    }

    public int getKey() {
        return key;
    }

    public Aluno getValue() {
        return value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }
}
