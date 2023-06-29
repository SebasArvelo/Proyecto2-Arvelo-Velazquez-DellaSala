package proyecto2;

public class Cliente { 
    public String ci;
    public String primer_nombre;
    public String apellido;
    public String email;
    public String genero;
    public String llegada;

    public Cliente(String ci, String primer_nombre, String apellido, String email, String genero, String llegada){
        this.ci = ci.replaceAll(",", ".");
        this.primer_nombre = primer_nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.llegada = llegada;
    }

    public String obtenerInfo(){
        return "CI: " + ci + "\nNombre: " + primer_nombre + " " + apellido + "\nEmail: " + email + "\nGenero: " + genero + "\nLlegada: " + llegada;
    }
}
