package proyecto2;

public class HuespedesTD {
    Lista<Lista<Huesped>> tablaHash;
    int maximoHuespedes = 300;
    
    public class Huesped {
        String llave;
        int num_hab;
        Cliente cliente;
    
        public Huesped(int num_hab, String ci, String primer_nombre, String apellido, String email, String genero, String celular, String llegada){
            this.llave = primer_nombre + apellido;
            this.num_hab = num_hab;
            this.cliente = new Cliente(ci, primer_nombre, apellido, email, genero, llegada);
        }
    }
    
    public HuespedesTD(){
        tablaHash = new Lista<>();
        for (int i = 0; i < maximoHuespedes; i++) {
            tablaHash.agregar(new Lista<>());
        }
    }
    
    public void insertar(int num_hab, String ci, String primer_nombre, String apellido, String email, String genero, String celular, String llegada) {
        String llave = primer_nombre + apellido;
        Lista<Huesped> lista = tablaHash.obtener(Math.abs(llave.hashCode()) % maximoHuespedes);
        Huesped huespedNuevo = new Huesped(num_hab, ci, primer_nombre, apellido, email, genero, celular, llegada);
        lista.agregar(huespedNuevo);
    }
    
    public Cliente obtenerCliente(String llave){
        Lista<Huesped> lista = tablaHash.obtener(Math.abs(llave.hashCode()) % maximoHuespedes);
        
        if(lista == null)
            return null;
        else {
            Nodo<Huesped> h = lista.head;
            while(h != null){
                if (h.data.llave.equals(llave)){
                    return h.data.cliente;
                }
                h = h.next;
            } 
        }
       
        return null;
    }
    
    public int obtenerNumHab(String llave){
        Lista<Huesped> lista = tablaHash.obtener(Math.abs(llave.hashCode()) % maximoHuespedes);
        
        if(lista == null)
            return -1;
        else {
            Nodo<Huesped> h = lista.head;
            while(h != null){
                if (h.data.llave.equals(llave)){
                    return h.data.num_hab;
                }
                h = h.next;
            } 
        }
       
        return -1;
    }
    
    public int eliminar(String llave) {
        Lista<Huesped> lista = tablaHash.obtener(Math.abs(llave.hashCode()) % maximoHuespedes);
        
        if(lista == null)
            return -1;
        else {
            Nodo<Huesped> h = lista.head;
            while(h != null){
                if (h.data.llave.equals(llave)){
                    lista.eliminar(h.data);
                    return h.data.num_hab;
                }
                h = h.next;
            } 
        }
        return -1;
    }
}
