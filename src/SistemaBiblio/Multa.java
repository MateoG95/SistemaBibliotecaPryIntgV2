package SistemaBiblio;

public class Multa {
    private String codigoMulta;
    private Usuario usuario;
    private String fechaInicio;
    private String fechaFin;
    private double monto;
    private String motivo;

    public Multa(String codigoMulta, Usuario usuario, String fechaInicio, String fechaFin, double monto, String motivo) {
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

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
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
        return "\nCódigo Multa: " + codigoMulta + "\nUsuario: " + usuario.getNombre() +
                "\nFecha Inicio: " + fechaInicio + "\nFecha Fin: " + fechaFin +
                "\nMonto: $" + monto + "\nMotivo: " + motivo;
    }
}