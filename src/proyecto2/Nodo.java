package proyecto2;


public class Nodo<T> {
    T data;
    Nodo<T> next;

    public Nodo(T data) {
        this.data = data;
        this.next = null;
    }
}
