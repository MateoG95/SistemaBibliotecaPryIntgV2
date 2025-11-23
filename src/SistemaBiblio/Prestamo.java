package SistemaBiblio;

public class Prestamo {
    private String codigoPrestamo;
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean devuelto;
    private double multa;

    public Prestamo(String codigoPrestamo, Usuario usuario, Libro libro, String fechaPrestamo, String fechaDevolucion) {
        this.codigoPrestamo = codigoPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.multa = 0.0;
    }

    public void setCodigoPrestamo(String codigoPrestamo) {
        this.codigoPrestamo = codigoPrestamo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public double getMulta() {
        return multa;
    }

    @Override
    public String toString(){
        return "\nCódigo Préstamo: " + codigoPrestamo + "\nUsuario: " + usuario.getNombre() +
                "\nLibro: " + libro.getTitulo() + "\nFecha Préstamo: " + fechaPrestamo +
                "\nFecha Devolución: " + fechaDevolucion + "\nDevuelto: " + devuelto + "\nMulta: $" + multa;
    }
}
