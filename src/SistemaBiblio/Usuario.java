package SistemaBiblio;

public class Usuario extends Persona {
    private String codigoUsuario;
    private String tipo;
    private int maxLibrosPrestados;
    private boolean puedePrestar;
    private String fechaFinPenalizacion;

    public Usuario(String cedula, String nombre, String telefono, String email,
                   String codigoUsuario, String tipo) {
        super(cedula, nombre, telefono, email);

        // Validación del código de usuario (ID Banner)
        if (!validarCodigoUsuario(codigoUsuario)) {
            throw new IllegalArgumentException("Código de usuario inválido. Debe comenzar con 'A' seguido de 8 dígitos.");
        }

        this.codigoUsuario = codigoUsuario;
        this.tipo = tipo;
        this.maxLibrosPrestados = tipo.equalsIgnoreCase("Estudiante") ? 3 : 5;
        this.puedePrestar = true;
        this.fechaFinPenalizacion = "";
    }

    // Metodo para validar el ID Banner
    private boolean validarCodigoUsuario(String codigo) {
        if (codigo == null || codigo.length() != 9) {
            return false;
        }
        // Debe comenzar con 'A' y tener 8 dígitos después
        if (!codigo.startsWith("A")) {
            return false;
        }
        // Verificar que los siguientes 8 caracteres sean dígitos
        String numeros = codigo.substring(1);
        for (char c : numeros.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.maxLibrosPrestados = tipo.equalsIgnoreCase("Estudiante") ? 3 : 5;
    }

    public void setMaxLibrosPrestados(int maxLibrosPrestados) {
        this.maxLibrosPrestados = maxLibrosPrestados;
    }

    public void setPuedePrestar(boolean puedePrestar) {
        this.puedePrestar = puedePrestar;
    }

    public void setFechaFinPenalizacion(String fechaFinPenalizacion) {
        this.fechaFinPenalizacion = fechaFinPenalizacion;
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

    public boolean isPuedePrestar() {
        return puedePrestar;
    }

    public String getFechaFinPenalizacion() {
        return fechaFinPenalizacion;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCódigo Usuario: " + codigoUsuario + "\nTipo: " + tipo +
                "\nLímite préstamos: " + maxLibrosPrestados + "\nPuede prestar: " + puedePrestar +
                (fechaFinPenalizacion.isEmpty() ? "" : "\nFin penalización: " + fechaFinPenalizacion);
    }
}