package proyecto2;

public class ReservacionesABB {
    private Reservacion root = null;
    
    public void insertarReservacion(String ci, String primer_nombre, String segundo_nombre, String email, String genero, String tipo_hab, String celular, String llegada, String salida) {
        Reservacion res = new Reservacion(ci, primer_nombre, segundo_nombre, email, genero, tipo_hab, celular, llegada, salida);
        root = insertarNodo(root, res);
    }

    private Reservacion insertarNodo(Reservacion actual, Reservacion res) {
        if (actual == null) {
            return res;
        }
        else{
            if (res.ci.compareTo(actual.ci) < 0) {
                actual.left = insertarNodo(actual.left, res);
            } else if (res.ci.compareTo(actual.ci) > 0) {
                actual.right = insertarNodo(actual.right, res);
            } else {
                return actual;
            }
            return actual;
        }
    }
    
    public Reservacion obtenerReservacion(String ci){
        Reservacion nodo = buscarNodo(root, ci);
        return nodo;
    }
    
    public String obtenerInfoReservacion(String ci) {
        Reservacion nodo = buscarNodo(root, ci);
        String info =  "No hay un cliente con este \nnúmero de cédula";
        if(nodo != null){
            info = "Los datos del cliente con esta \nreservación son: \n\nNombre: " + nodo.primer_nombre + " " + nodo.segundo_nombre + "\n" + "Email: " + nodo.email + "\n" +
                    "Género: " + nodo.genero + "\n" + "Tipo de habitación: " + nodo.tipo_hab + "\n" + 
                    "Teléfono celular: " + nodo.celular + "\n" + "Llegada: " + nodo.llegada + "\n";
            return info;
        }
        return info;
    }

    private Reservacion buscarNodo(Reservacion actual, String ci) {
        if (actual == null)
            return null;
        else {
            if (actual.ci.equals(ci)) {
                return actual;
            } else if (ci.compareTo(actual.ci) < 0) {
                return buscarNodo(actual.left, ci);
            } else {
                return buscarNodo(actual.right, ci);
            }
        }
    }
    
    public void eliminarReservacion(String ci) { 
        root = eliminar(root, ci); 
    } 
   
    private Reservacion eliminar(Reservacion actual, String ci)  { 
        if (actual == null)  
            return actual; 
   
        if (ci.compareTo(actual.ci) < 0)
            actual.left = eliminar(actual.left, ci); 
        else if (ci.compareTo(actual.ci) > 0)
            actual.right = eliminar(actual.right, ci); 
        else  { 
            if (actual.left == null) 
                return actual.right; 
            else if (actual.right == null) 
                return actual.left; 
   
            actual.ci = min(actual.right); 
            actual.right = eliminar(actual.right, actual.ci); 
        } 
        return actual; 
    } 
   
    private String min(Reservacion actual)  { 
        String min = actual.ci; 
        while (actual.left != null)  { 
            min = actual.left.ci; 
            actual = actual.left; 
        } 
        return min; 
    } 
}
