package SistemaBiblio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Multa {
    private String codigoMulta;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double monto;
    private String motivo;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Multa(String codigoMulta, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin, double monto, String motivo) {
        this.codigoMulta = codigoMulta;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.monto = monto;
        this.motivo = motivo;
    }

    public void setCodigoMulta(String codigoMulta) {
        this.codigoMulta = codigoMulta;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCodigoMulta() {
        return codigoMulta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getMonto() {
        return monto;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString(){
        String fechaInicioStr = fechaInicio.format(formatter);
        String fechaFinStr = fechaFin.format(formatter);

        return "\nCódigo Multa: " + codigoMulta +
                "\nUsuario: " + usuario.getNombre() +
                "\nID Banner: " + usuario.getCodigoUsuario() +
                "\nFecha Inicio: " + fechaInicioStr +
                "\nFecha Fin: " + fechaFinStr +
                "\nMonto: $" + String.format("%.2f", monto) +
                "\nMotivo: " + motivo;
    }
}