package SistemaBiblio;

public class Usuario extends Persona {
    private String codigoUsuario;
    private String tipo; // "Estudiante" o "Profesor"
    private int maxLibrosPrestados;

    public Usuario(String cedula, String nombre, String telefono, String email, String codigoUsuario, String tipo) {
        super(cedula, nombre, telefono, email);
        this.codigoUsuario = codigoUsuario;
        this.tipo = tipo;
        // Estudiantes pueden llevar 3 libros, profesores 5
        this.maxLibrosPrestados = tipo.equals("Estudiante") ? 3 : 5;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.maxLibrosPrestados = tipo.equals("Estudiante") ? 3 : 5;
    }

    public void setMaxLibrosPrestados(int maxLibrosPrestados) {
        this.maxLibrosPrestados = maxLibrosPrestados;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public int getMaxLibrosPrestados() {
        return maxLibrosPrestados;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCódigo Usuario: " + codigoUsuario + "\nTipo: " + tipo +
                "\nLímite préstamos: " + maxLibrosPrestados;
    }
}