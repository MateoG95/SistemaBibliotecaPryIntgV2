package SistemaBiblio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    private String codigoPrestamo;
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    private double multa;
    private String sucursal;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Prestamo(String codigoPrestamo, Usuario usuario, Libro libro,
                    LocalDate fechaPrestamo, LocalDate fechaDevolucion, String sucursal) {
        this.codigoPrestamo = codigoPrestamo;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = false;
        this.multa = 0.0;
        this.sucursal = sucursal;
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

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
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

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public double getMulta() {
        return multa;
    }

    public String getSucursal() {
        return sucursal;
    }

    @Override
    public String toString(){
        String fechaPrestamoStr = fechaPrestamo.format(formatter);
        String fechaDevolucionStr = fechaDevolucion.format(formatter);

        return "\nCódigo Préstamo: " + codigoPrestamo +
                "\nUsuario: " + usuario.getNombre() +
                "\nLibro: " + libro.getTitulo() +
                "\nFecha Préstamo: " + fechaPrestamoStr +
                "\nFecha Devolución: " + fechaDevolucionStr +
                "\nDevuelto: " + devuelto +
                "\nMulta: $" + String.format("%.2f", multa) +
                "\nSucursal: " + sucursal;
    }
}