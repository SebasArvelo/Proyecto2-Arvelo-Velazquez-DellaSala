package proyecto2;

public class Reservacion {
        String ci;
        String primer_nombre;
        String segundo_nombre;
        String email;
        String genero;
        String tipo_hab;
        String celular;
        String llegada;
        String salida;
        
        Reservacion left = null;
        Reservacion right = null;
    
        public Reservacion(String ci, String primer_nombre, String segundo_nombre, String email, String genero, String tipo_hab, String celular, String llegada, String salida){
            this.ci = ci.replaceAll(",", ".");
            this.primer_nombre = primer_nombre;
            this.segundo_nombre = segundo_nombre;
            this.email = email;
            this.genero = genero;
            this.tipo_hab = tipo_hab;
            this.celular = celular;
            this.llegada = llegada;
            this.salida = salida;
        }
        
        public String getCi(){
            return ci;
        }
        public String getNombre(){
            return primer_nombre;
        }
        public String getApellido(){
            return segundo_nombre;
        }
        public String getEmail(){
            return email;
        }
        public String getGenero(){
            return genero;
        }
        public String getCelular(){
            return celular;
        }
        public String getLlegada(){
            return llegada;
        }
        public String getTipoHab(){
            return tipo_hab;
        }
    }