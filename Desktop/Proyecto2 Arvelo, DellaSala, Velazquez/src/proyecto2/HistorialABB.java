package proyecto2;

public class HistorialABB {
    private Habitacion root = null;
    private Habitacion HabitacionEncontrada = null;
    
    public class Habitacion {
        int num_hab;
        String tipo_hab;
        String piso;
        Boolean disponible;
        Lista<Cliente> historico = new Lista<>();
        
        Habitacion left = null;
        Habitacion right = null;
        
        Habitacion(int num_hab, String tipo_hab, String piso) {
            this.num_hab = num_hab;  
            this.tipo_hab = tipo_hab;
            this.piso = piso;
            this.disponible = true;
        }
    }
    
    public void insertarHabitacion(int num_hab, String tipo_hab, String piso) {
        Habitacion hab = new Habitacion(num_hab, tipo_hab, piso);
        root = insertarNodo(root, hab);
    }
    
    public void insertarRegistro(int num_hab, String ci, String primer_nombre, String apellido, String email, String genero, String llegada) {
        Habitacion hab = obtenerHabitacion(num_hab);
        hab.historico.agregar(new Cliente(ci, primer_nombre, apellido, email, genero, llegada));
    }

    private Habitacion insertarNodo(Habitacion actual, Habitacion nuevaHab) {
        if (actual == null)
            return nuevaHab;
        else {
            if (actual.num_hab < nuevaHab.num_hab) {
                actual.left = insertarNodo(actual.left, nuevaHab);
            } else if (actual.num_hab > nuevaHab.num_hab) {
                actual.right = insertarNodo(actual.right, nuevaHab);
            } else {
                return actual;
            }
            return actual;
        }
    }
    
    public Habitacion obtenerHabitacion(int num_hab) {
        Habitacion nodo = buscarNodo(root, num_hab);
        return nodo;
    }

    private Habitacion buscarNodo(Habitacion actual, int num_hab) {
        if (actual == null)
            return null;
        else {
            if (actual.num_hab == num_hab) {
                return actual;
            } else if (actual.num_hab < num_hab) {
                return buscarNodo(actual.left, num_hab);
            } else {
                return buscarNodo(actual.right, num_hab);
            }
        }
    }
    
    public String obtenerHistorico(int num_hab){
        Habitacion hab = obtenerHabitacion(num_hab);
        String historial =  "Este número de habitación es inválido";
        
        if(hab != null){
            Lista<Cliente> huespedes = hab.historico;
            historial = "Se han hospedado " + Integer.toString(huespedes.size()) + " clientes: \n\n";
            for(int i=0; i < huespedes.size(); i++){
                historial += huespedes.obtener(i).obtenerInfo() + "\n\n";
            }
            historial = historial .substring(0, historial.length() - 2);
        }
        
        return historial;
    }
    
    public void ocuparHabitacion(int num_hab){
        Habitacion h = obtenerHabitacion(num_hab);
        h.disponible = false;
    }
    
    public void liberarHabitacion(int num_hab){
        Habitacion h = obtenerHabitacion(num_hab);
        h.disponible = true;
    }
    
    public int obtenerHabitacionLibre(String tipo_hab){
        this.HabitacionEncontrada = null;
        buscarTipoHab(root, tipo_hab);
        if(HabitacionEncontrada!= null){
            return HabitacionEncontrada.num_hab;
        }
        return -1;
    }
    
    public void buscarTipoHab(Habitacion actual, String tipo_hab) {
        if (actual != null) {
            if(actual.tipo_hab.equals(tipo_hab) && actual.disponible){
                HabitacionEncontrada = actual;
                return;
            }
            buscarTipoHab(actual.left,tipo_hab);
            buscarTipoHab(actual.right, tipo_hab);
        }
    }
}
