package SistemaBiblio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transferencia {
    private String codigoTransferencia;
    private Libro libro;
    private String sucursalOrigen;
    private String sucursalDestino;
    private LocalDate fechaSolicitud;
    private LocalDate fechaEstimadaEntrega;
    private LocalDate fechaRealEntrega;
    private Usuario solicitante;
    private String estado; // "SOLICITADA", "EN_TRANSITO", "RECIBIDA", "CANCELADA"
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Transferencia(String codigoTransferencia, Libro libro, String sucursalOrigen,
                         String sucursalDestino, Usuario solicitante) {
        this.codigoTransferencia = codigoTransferencia;
        this.libro = libro;
        this.sucursalOrigen = sucursalOrigen;
        this.sucursalDestino = sucursalDestino;
        this.solicitante = solicitante;
        this.fechaSolicitud = LocalDate.now();
        this.fechaEstimadaEntrega = LocalDate.now().plusDays(3); // 3 días para transferencia
        this.fechaRealEntrega = null;
        this.estado = "SOLICITADA";

        // Marcar libro como no disponible temporalmente
        this.libro.setDisponible(false);
    }

    // Getters y Setters
    public String getCodigoTransferencia() {
        return codigoTransferencia;
    }

    public void setCodigoTransferencia(String codigoTransferencia) {
        this.codigoTransferencia = codigoTransferencia;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getSucursalOrigen() {
        return sucursalOrigen;
    }

    public void setSucursalOrigen(String sucursalOrigen) {
        this.sucursalOrigen = sucursalOrigen;
    }

    public String getSucursalDestino() {
        return sucursalDestino;
    }

    public void setSucursalDestino(String sucursalDestino) {
        this.sucursalDestino = sucursalDestino;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDate fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public LocalDate getFechaRealEntrega() {
        return fechaRealEntrega;
    }

    public void setFechaRealEntrega(LocalDate fechaRealEntrega) {
        this.fechaRealEntrega = fechaRealEntrega;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para marcar como en tránsito
    public void marcarEnTransito() {
        this.estado = "EN_TRANSITO";
        System.out.println("Transferencia " + codigoTransferencia + " en tránsito.");
    }

    // Método para marcar como recibida
    public void marcarRecibida() {
        this.estado = "RECIBIDA";
        this.fechaRealEntrega = LocalDate.now();
        this.libro.setSucursal(sucursalDestino);
        this.libro.setDisponible(true);
        System.out.println("Transferencia " + codigoTransferencia + " recibida en " + sucursalDestino);
    }

    // Método para cancelar transferencia
    public void cancelarTransferencia() {
        this.estado = "CANCELADA";
        this.libro.setDisponible(true);
        System.out.println("Transferencia " + codigoTransferencia + " cancelada.");
    }

    @Override
    public String toString() {
        String fechaSolicitudStr = fechaSolicitud.format(formatter);
        String fechaEstimadaStr = fechaEstimadaEntrega.format(formatter);
        String fechaRealStr = (fechaRealEntrega != null) ? fechaRealEntrega.format(formatter) : "No entregado";

        return "\nCódigo Transferencia: " + codigoTransferencia +
                "\nLibro: " + libro.getTitulo() + " (ISBN: " + libro.getIsbn() + ")" +
                "\nSucursal Origen: " + sucursalOrigen +
                "\nSucursal Destino: " + sucursalDestino +
                "\nSolicitante: " + solicitante.getNombre() +
                "\nFecha Solicitud: " + fechaSolicitudStr +
                "\nFecha Estimada Entrega: " + fechaEstimadaStr +
                "\nFecha Real Entrega: " + fechaRealStr +
                "\nEstado: " + estado;
    }
}