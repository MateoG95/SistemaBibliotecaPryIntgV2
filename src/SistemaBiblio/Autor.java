package SistemaBiblio;

public class Autor {
    private String codigo;
    private String nombre;
    private String nacionalidad;

    public Autor(String codigo, String nombre, String nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString(){
        return "\nCódigo: " + codigo + "\nNombre: " + nombre + "\nNacionalidad: " + nacionalidad;
    }
}
