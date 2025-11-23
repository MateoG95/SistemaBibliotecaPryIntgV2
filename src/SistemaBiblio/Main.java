package SistemaBiblio;

import SistemaBiblio.*;

public class Main {
    public static void main(String[] args) {
        // Crear el gestor de biblioteca
        GestorBiblioteca biblioteca = new GestorBiblioteca();

        // Crear autores
        Autor autor1 = new Autor("AUT001", "Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("AUT002", "Isabel Allende", "Chilena");
        Autor autor3 = new Autor("AUT003", "Mario Vargas Llosa", "Peruana");

        // Agregar autores a la biblioteca
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        biblioteca.agregarAutor(autor3);

        // Crear libros
        Libro libro1 = new Libro("ISBN001", "Cien años de soledad", "Novela", 1967, autor1);
        Libro libro2 = new Libro("ISBN002", "La casa de los espíritus", "Novela", 1982, autor2);
        Libro libro3 = new Libro("ISBN003", "La ciudad y los perros", "Novela", 1963, autor3);
        Libro libro4 = new Libro("ISBN004", "El amor en los tiempos del cólera", "Novela", 1985, autor1);

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);

        // Crear usuarios
        Usuario usuario1 = new Usuario("12345678", "Juan Pérez", "3001234567", "juan@email.com", "USER001", "Estudiante");
        Usuario usuario2 = new Usuario("87654321", "María García", "3007654321", "maria@email.com", "USER002", "Profesor");

        // Agregar usuarios a la biblioteca
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);

        // Realizar préstamos
        System.out.println("=== REALIZANDO PRÉSTAMOS ===");
        biblioteca.realizarPrestamo(usuario1, libro1, "01/09/2024", "15/09/2024");
        biblioteca.realizarPrestamo(usuario1, libro2, "01/09/2024", "15/09/2024");
        biblioteca.realizarPrestamo(usuario2, libro3, "02/09/2024", "16/09/2024");

        // Mostrar información del sistema
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        biblioteca.listarAutores();
        biblioteca.listarLibros();
        biblioteca.listarUsuarios();
        biblioteca.listarPrestamos();

        System.out.println("\n--- LIBROS DISPONIBLES ---");
        biblioteca.listarLibrosDisponibles();

        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");
        biblioteca.listarPrestamosActivos();

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Total autores: " + biblioteca.getCantidadAutores());
        System.out.println("Total libros: " + biblioteca.getCantidadLibros());
        System.out.println("Total usuarios: " + biblioteca.getCantidadUsuarios());
        System.out.println("Total préstamos: " + biblioteca.getCantidadPrestamos());

        // Ejemplo de devolución
        System.out.println("\n=== PROCESANDO DEVOLUCIÓN ===");
        biblioteca.devolverLibro("PRE1", "20/09/2024"); // Con retraso

        System.out.println("\n--- SITUACIÓN DESPUÉS DE DEVOLUCIÓN ---");
        biblioteca.listarPrestamos();
        biblioteca.listarLibrosDisponibles();
    }
}
