package SistemaBiblio;

public class Libro {
    private String isbn;
    private String titulo;
    private String genero;
    private int anio;
    private Autor autor;
    private boolean disponible;

    public Libro(String isbn, String titulo, String genero, int anio, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
        this.autor = autor;
        this.disponible = true;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAño(int anio) {
        this.anio = anio;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString(){
        return "\nISBN: " + isbn + "\nTítulo: " + titulo + "\nGénero: " + genero +
                "\nAño: " + anio + "\nAutor: " + autor.getNombre() + "\nDisponible: " + disponible;
    }
}
