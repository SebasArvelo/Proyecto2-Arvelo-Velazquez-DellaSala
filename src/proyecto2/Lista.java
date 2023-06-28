package proyecto2;

class Lista<T> {
    Nodo<T> head;
    
    public void agregar(T data) {
        if (head == null) {
            head = new Nodo<>(data);
            return;
        }

        Nodo<T> actual = head;
        while (actual.next != null) {
            actual = actual.next;
        }

        actual.next = new Nodo<>(data);
    }
        
    public void eliminar(T key){
        if(head == null)
            return; 
        else if(head.data == key){
            head = head.next;
            return;
        } else {
            Nodo actual = head;
            while(actual.next != null){
                if(actual.next.data == key){
                    actual.next = actual.next.next;
                    return;
                }
                actual = actual.next;
            }
            return;
        }
    }
    
    public T obtener(int index) {
        if (head == null) {
            return null;
        } else if (index == 0) {
            return head.data;
        } else {
            int i = 1;
            Nodo<T> actual = head;
            while (actual.next != null) {
                if (i == index) {
                    return actual.next.data;
                } else {
                    actual = actual.next;
                    i++;
                }
            }
            return null;
        }  
    }
    
    public int size() {
        if (head == null) {
            return 0;
        } else {
            int i = 1;
            Nodo<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
                i++;
            }
            return i;
        }      
    }
}
