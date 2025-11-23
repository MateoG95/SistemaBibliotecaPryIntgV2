package SistemaBiblio;

public class GestorBiblioteca {
    private Autor[] autores;
    private Libro[] libros;
    private Usuario[] usuarios;
    private Prestamo[] prestamos;
    private int contadorAutores;
    private int contadorLibros;
    private int contadorUsuarios;
    private int contadorPrestamos;

    public GestorBiblioteca() {
        this.autores = new Autor[100];
        this.libros = new Libro[200];
        this.usuarios = new Usuario[50];
        this.prestamos = new Prestamo[300];
        this.contadorAutores = 0;
        this.contadorLibros = 0;
        this.contadorUsuarios = 0;
        this.contadorPrestamos = 0;
    }

    // MÉTODOS PARA AUTORES
    public void agregarAutor(Autor autor) {
        if (contadorAutores < autores.length) {
            autores[contadorAutores] = autor;
            contadorAutores++;
        }
    }

    public Autor buscarAutor(String codigo) {
        for (int i = 0; i < contadorAutores; i++) {
            if (autores[i].getCodigo().equals(codigo)) {
                return autores[i];
            }
        }
        return null;
    }

    public void listarAutores() {
        System.out.println("\n--- LISTA DE AUTORES ---");
        for (int i = 0; i < contadorAutores; i++) {
            System.out.println(autores[i]);
            System.out.println("-------------------");
        }
    }

    // MÉTODOS PARA LIBROS
    public void agregarLibro(Libro libro) {
        if (contadorLibros < libros.length) {
            libros[contadorLibros] = libro;
            contadorLibros++;
        }
    }

    public Libro buscarLibro(String isbn) {
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getIsbn().equals(isbn)) {
                return libros[i];
            }
        }
        return null;
    }

    public void listarLibros() {
        System.out.println("\n--- LISTA DE LIBROS ---");
        for (int i = 0; i < contadorLibros; i++) {
            System.out.println(libros[i]);
            System.out.println("-------------------");
        }
    }

    public void listarLibrosDisponibles() {
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].isDisponible()) {
                System.out.println(libros[i]);
                System.out.println("-------------------");
            }
        }
    }

    // MÉTODOS PARA USUARIOS
    public void agregarUsuario(Usuario usuario) {
        if (contadorUsuarios < usuarios.length) {
            usuarios[contadorUsuarios] = usuario;
            contadorUsuarios++;
        }
    }

    public Usuario buscarUsuario(String codigoUsuario) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getCodigoUsuario().equals(codigoUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (int i = 0; i < contadorUsuarios; i++) {
            System.out.println(usuarios[i]);
            System.out.println("-------------------");
        }
    }

    // MÉTODOS PARA PRÉSTAMOS
    public void realizarPrestamo(Usuario usuario, Libro libro, String fechaPrestamo, String fechaDevolucion) {
        if (contadorPrestamos < prestamos.length) {
            // Verificar que el libro esté disponible
            if (!libro.isDisponible()) {
                System.out.println("El libro no está disponible para préstamo");
                return;
            }

            // Verificar que el usuario no exceda su límite
            int prestamosActivos = contarPrestamosActivos(usuario);
            if (prestamosActivos >= usuario.getMaxLibrosPrestados()) {
                System.out.println("El usuario ha alcanzado su límite de préstamos");
                return;
            }

            // Crear y registrar el préstamo
            String codigoPrestamo = "PRE" + (contadorPrestamos + 1);
            Prestamo prestamo = new Prestamo(codigoPrestamo, usuario, libro, fechaPrestamo, fechaDevolucion);
            prestamos[contadorPrestamos] = prestamo;
            contadorPrestamos++;

            // Marcar libro como no disponible
            libro.setDisponible(false);

            System.out.println("Préstamo realizado exitosamente: " + codigoPrestamo);
        }
    }

    private int contarPrestamosActivos(Usuario usuario) {
        int count = 0;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getUsuario().equals(usuario) && !prestamos[i].isDevuelto()) {
                count++;
            }
        }
        return count;
    }

    public void devolverLibro(String codigoPrestamo, String fechaRealDevolucion) {
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getCodigoPrestamo().equals(codigoPrestamo) && !prestamos[i].isDevuelto()) {
                // Marcar como devuelto
                prestamos[i].setDevuelto(true);
                // Marcar libro como disponible
                prestamos[i].getLibro().setDisponible(true);

                // Calcular multa si hay retraso (simulación simple)
                if (!fechaRealDevolucion.equals(prestamos[i].getFechaDevolucion())) {
                    prestamos[i].setMulta(5.0); // Multa de $5 por retraso
                    System.out.println("Multa aplicada: $5.00 por retraso en la devolución");
                }

                System.out.println("Libro devuelto exitosamente");
                return;
            }
        }
        System.out.println("Préstamo no encontrado o ya devuelto");
    }

    public void listarPrestamos() {
        System.out.println("\n--- LISTA DE PRÉSTAMOS ---");
        for (int i = 0; i < contadorPrestamos; i++) {
            System.out.println(prestamos[i]);
            System.out.println("-------------------");
        }
    }

    public void listarPrestamosActivos() {
        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        for (int i = 0; i < contadorPrestamos; i++) {
            if (!prestamos[i].isDevuelto()) {
                System.out.println(prestamos[i]);
                System.out.println("-------------------");
            }
        }
    }

    // GETTERS PARA CONTADORES
    public int getCantidadAutores() {
        return contadorAutores;
    }

    public int getCantidadLibros() {
        return contadorLibros;
    }

    public int getCantidadUsuarios() {
        return contadorUsuarios;
    }

    public int getCantidadPrestamos() {
        return contadorPrestamos;
    }
}