package SistemaBiblio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class GestorBiblioteca {
    private Autor[] autores;
    private Libro[] libros;
    private Usuario[] usuarios;
    private Prestamo[] prestamos;
    private Multa[] multas;
    private Transferencia[] transferencias;
    private int contadorAutores;
    private int contadorLibros;
    private int contadorUsuarios;
    private int contadorPrestamos;
    private int contadorMultas;
    private int contadorTransferencias;
    private Scanner scanner;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public GestorBiblioteca() {
        this.autores = new Autor[100];
        this.libros = new Libro[200];
        this.usuarios = new Usuario[50];
        this.prestamos = new Prestamo[300];
        this.multas = new Multa[100];
        this.transferencias = new Transferencia[100];
        this.contadorAutores = 0;
        this.contadorLibros = 0;
        this.contadorUsuarios = 0;
        this.contadorPrestamos = 0;
        this.contadorMultas = 0;
        this.contadorTransferencias = 0;
        this.scanner = new Scanner(System.in);

        inicializarDatos();
    }

    private void inicializarDatos() {
        try {
            Autor autor1 = new Autor("AUT001", "Gabriel Garcia Marquez", "Colombiana");
            Autor autor2 = new Autor("AUT002", "Isabel Allende", "Chilena");
            Autor autor3 = new Autor("AUT003", "Mario Vargas Llosa", "Peruana");
            Autor autor4 = new Autor("AUT004", "Isaac Asimov", "Rusa");
            Autor autor5 = new Autor("AUT005", "Stephen King", "Estadounidense");
            Autor autor6 = new Autor("AUT006", "H.P. Lovecraft", "Estadounidense");

            agregarAutor(autor1);
            agregarAutor(autor2);
            agregarAutor(autor3);
            agregarAutor(autor4);
            agregarAutor(autor5);
            agregarAutor(autor6);

            agregarLibro(new Libro("ISBN001", "Cien anos de soledad", "Novela", 1967, autor1, "Biblioteca Granados"));
            agregarLibro(new Libro("ISBN002", "La casa de los espiritus", "Novela", 1982, autor2, "Biblioteca Granados"));
            agregarLibro(new Libro("ISBN003", "Fundacion", "Ciencia Ficcion", 1951, autor4, "Biblioteca Granados"));
            agregarLibro(new Libro("ISBN004", "Yo, robot", "Ciencia Ficcion", 1950, autor4, "Biblioteca Granados"));
            agregarLibro(new Libro("ISBN005", "It", "Terror", 1986, autor5, "Biblioteca Granados"));
            agregarLibro(new Libro("ISBN006", "El resplandor", "Terror", 1977, autor5, "Biblioteca Granados"));

            agregarLibro(new Libro("ISBN007", "La ciudad y los perros", "Novela", 1963, autor3, "Biblioteca Park"));
            agregarLibro(new Libro("ISBN008", "El amor en los tiempos del colera", "Novela", 1985, autor1, "Biblioteca Park"));
            agregarLibro(new Libro("ISBN009", "La llamada de Cthulhu", "Terror", 1928, autor6, "Biblioteca Park"));
            agregarLibro(new Libro("ISBN010", "El fin de la eternidad", "Ciencia Ficcion", 1955, autor4, "Biblioteca Park"));
            agregarLibro(new Libro("ISBN011", "Carrie", "Terror", 1974, autor5, "Biblioteca Park"));
            agregarLibro(new Libro("ISBN012", "La niebla", "Terror", 1980, autor5, "Biblioteca Park"));

            agregarUsuario(new Usuario("12345678", "Juan Perez", "3001234567", "juan@email.com", "A00117567", "Estudiante"));
            agregarUsuario(new Usuario("87654321", "Maria Garcia", "3007654321", "maria@email.com", "A00117568", "Profesor"));
            agregarUsuario(new Usuario("11223344", "Carlos Lopez", "3001122334", "carlos@email.com", "A00117569", "Estudiante"));
            agregarUsuario(new Usuario("55667788", "Ana Rodriguez", "3005566778", "ana@email.com", "A00117570", "Profesor"));

            System.out.println("Datos inicializados exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al inicializar datos: " + e.getMessage());
        }
    }

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

    public void listarLibrosPorSucursal(String sucursal) {
        System.out.println("\n--- LIBROS EN " + sucursal + " ---");
        boolean encontrados = false;
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getSucursal().equals(sucursal)) {
                System.out.println(libros[i]);
                System.out.println("-------------------");
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron libros en esta sucursal.");
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

    public void listarLibrosDisponiblesPorSucursal(String sucursal) {
        System.out.println("\n--- LIBROS DISPONIBLES EN " + sucursal + " ---");
        boolean encontrados = false;
        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].isDisponible() && libros[i].getSucursal().equals(sucursal)) {
                System.out.println("ISBN: " + libros[i].getIsbn() + " - " + libros[i].getTitulo() +
                        " (" + libros[i].getGenero() + ")");
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No hay libros disponibles en esta sucursal.");
        }
    }

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

    public void realizarPrestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo, int plazo) {
        if (contadorPrestamos < prestamos.length) {
            if (!usuario.isPuedePrestar()) {
                System.out.println("Penalizacion por falta de puntualidad: No Procede al prestamo");
                System.out.println("Fecha fin de penalizacion: " + usuario.getFechaFinPenalizacion());
                return;
            }

            if (!libro.isDisponible()) {
                System.out.println("El libro no esta disponible para prestamo");
                System.out.println("Sugerencia: Puede solicitar una transferencia entre sucursales.");
                return;
            }

            int prestamosActivos = contarPrestamosActivos(usuario);
            if (prestamosActivos >= usuario.getMaxLibrosPrestados()) {
                System.out.println("El usuario ha alcanzado su limite de prestamos");
                return;
            }

            LocalDate fechaDevolucion = calcularFechaDevolucion(fechaPrestamo, plazo);

            String codigoPrestamo = "PRE" + (contadorPrestamos + 1);
            Prestamo prestamo = new Prestamo(codigoPrestamo, usuario, libro, fechaPrestamo, fechaDevolucion, libro.getSucursal());
            prestamos[contadorPrestamos] = prestamo;
            contadorPrestamos++;

            libro.setDisponible(false);

            System.out.println("\nSolicitud realizada con exito");
            System.out.println("Libro: " + libro.getTitulo());
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Codigo de prestamo: " + codigoPrestamo);
            System.out.println("Fecha de devolucion: " + fechaDevolucion.format(formatter));
        }
    }

    private LocalDate calcularFechaDevolucion(LocalDate fechaPrestamo, int plazo) {
        LocalDate fechaDevolucion = fechaPrestamo.plusWeeks(plazo);

        while (fechaDevolucion.getDayOfWeek() == DayOfWeek.SATURDAY ||
                fechaDevolucion.getDayOfWeek() == DayOfWeek.SUNDAY) {
            fechaDevolucion = fechaDevolucion.plusDays(1);
        }

        return fechaDevolucion;
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

    public void devolverLibro(String codigoUsuario, String isbnLibro, LocalDate fechaRealDevolucion) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        boolean libroEncontrado = false;
        for (int i = 0; i < contadorPrestamos; i++) {
            Prestamo prestamo = prestamos[i];
            if (prestamo.getUsuario().equals(usuario) &&
                    !prestamo.isDevuelto() &&
                    prestamo.getLibro().getIsbn().equals(isbnLibro)) {

                prestamo.setDevuelto(true);
                prestamo.getLibro().setDisponible(true);
                libroEncontrado = true;

                if (hayRetraso(prestamo.getFechaDevolucion(), fechaRealDevolucion)) {
                    long diasRetraso = ChronoUnit.DAYS.between(prestamo.getFechaDevolucion(), fechaRealDevolucion);
                    System.out.println("Advertencia: Por impuntualidad de entrega");
                    System.out.println("Dias de retraso: " + diasRetraso);

                    aplicarPenalizacion(usuario, fechaRealDevolucion);
                } else {
                    System.out.println("Libro devuelto exitosamente");
                }
                break;
            }
        }

        if (!libroEncontrado) {
            System.out.println("No se encontro el libro para devolver");
        }
    }

    private boolean hayRetraso(LocalDate fechaEsperada, LocalDate fechaReal) {
        return fechaReal.isAfter(fechaEsperada);
    }

    private void aplicarPenalizacion(Usuario usuario, LocalDate fechaInicio) {
        LocalDate fechaFin = fechaInicio.plusMonths(2);

        while (fechaFin.getDayOfWeek() == DayOfWeek.SATURDAY ||
                fechaFin.getDayOfWeek() == DayOfWeek.SUNDAY) {
            fechaFin = fechaFin.plusDays(1);
        }

        usuario.setPuedePrestar(false);
        usuario.setFechaFinPenalizacion(fechaFin.format(formatter));

        String codigoMulta = "MUL" + (contadorMultas + 1);
        Multa multa = new Multa(codigoMulta, usuario, fechaInicio, fechaFin, 10.0, "Retraso en devolucion");
        multas[contadorMultas] = multa;
        contadorMultas++;

        System.out.println("Penalizacion: Por impuntualidad de entrega - 2 meses");
        System.out.println("Fin de penalizacion: " + fechaFin.format(formatter));
    }

    public void listarMultas() {
        System.out.println("\n--- LISTA DE MULTAS ---");
        if (contadorMultas == 0) {
            System.out.println("No hay multas registradas en el sistema.");
            return;
        }

        for (int i = 0; i < contadorMultas; i++) {
            System.out.println(multas[i]);
            System.out.println("-------------------");
        }
    }

    public void listarPrestamosPendientesUsuario(String codigoUsuario) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.println("\n--- PRESTAMOS PENDIENTES DE " + usuario.getNombre() + " ---");
        boolean encontrados = false;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getUsuario().equals(usuario) && !prestamos[i].isDevuelto()) {
                String fechaDev = prestamos[i].getFechaDevolucion().format(formatter);
                System.out.println("ISBN: " + prestamos[i].getLibro().getIsbn() +
                        " - " + prestamos[i].getLibro().getTitulo() +
                        " - Fecha devolucion: " + fechaDev);
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No tiene prestamos pendientes");
        }
    }

    public void listarPrestamos() {
        System.out.println("\n--- LISTA DE PRESTAMOS ---");
        for (int i = 0; i < contadorPrestamos; i++) {
            System.out.println(prestamos[i]);
            System.out.println("-------------------");
        }
    }

    public void listarPrestamosActivos() {
        System.out.println("\n--- PRESTAMOS ACTIVOS ---");
        for (int i = 0; i < contadorPrestamos; i++) {
            if (!prestamos[i].isDevuelto()) {
                System.out.println(prestamos[i]);
                System.out.println("-------------------");
            }
        }
    }

    // METODOS PARA TRANSFERENCIAS
    public void solicitarTransferencia(String codigoUsuario, String isbnLibro, String sucursalDestino) {
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        Libro libro = buscarLibro(isbnLibro);
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }

        if (libro.getSucursal().equals(sucursalDestino)) {
            System.out.println("El libro ya se encuentra en la sucursal solicitada");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no esta disponible para transferencia");
            return;
        }

        String codigoTransferencia = "TRF" + (contadorTransferencias + 1);
        Transferencia transferencia = new Transferencia(codigoTransferencia, libro, libro.getSucursal(),
                sucursalDestino, usuario);
        transferencias[contadorTransferencias] = transferencia;
        contadorTransferencias++;

        System.out.println("Transferencia solicitada exitosamente");
        System.out.println("Codigo de transferencia: " + codigoTransferencia);
        System.out.println("Fecha estimada de entrega: " +
                transferencia.getFechaEstimadaEntrega().format(formatter));
    }

    public void procesarTransferencia(String codigoTransferencia) {
        Transferencia transferencia = buscarTransferencia(codigoTransferencia);
        if (transferencia == null) {
            System.out.println("Transferencia no encontrada");
            return;
        }

        if (transferencia.getEstado().equals("SOLICITADA")) {
            transferencia.marcarEnTransito();
        } else if (transferencia.getEstado().equals("EN_TRANSITO")) {
            transferencia.marcarRecibida();
        } else {
            System.out.println("La transferencia ya esta " + transferencia.getEstado());
        }
    }

    public void cancelarTransferencia(String codigoTransferencia) {
        Transferencia transferencia = buscarTransferencia(codigoTransferencia);
        if (transferencia == null) {
            System.out.println("Transferencia no encontrada");
            return;
        }

        if (transferencia.getEstado().equals("SOLICITADA") ||
                transferencia.getEstado().equals("EN_TRANSITO")) {
            transferencia.cancelarTransferencia();
        } else {
            System.out.println("No se puede cancelar una transferencia " + transferencia.getEstado());
        }
    }

    private Transferencia buscarTransferencia(String codigoTransferencia) {
        for (int i = 0; i < contadorTransferencias; i++) {
            if (transferencias[i].getCodigoTransferencia().equals(codigoTransferencia)) {
                return transferencias[i];
            }
        }
        return null;
    }

    public void listarTransferencias() {
        System.out.println("\n--- LISTA DE TRANSFERENCIAS ---");
        if (contadorTransferencias == 0) {
            System.out.println("No hay transferencias registradas.");
            return;
        }

        for (int i = 0; i < contadorTransferencias; i++) {
            System.out.println(transferencias[i]);
            System.out.println("-------------------");
        }
    }

    public void listarTransferenciasPorEstado(String estado) {
        System.out.println("\n--- TRANSFERENCIAS " + estado + " ---");
        boolean encontradas = false;
        for (int i = 0; i < contadorTransferencias; i++) {
            if (transferencias[i].getEstado().equals(estado)) {
                System.out.println(transferencias[i]);
                System.out.println("-------------------");
                encontradas = true;
            }
        }
        if (!encontradas) {
            System.out.println("No hay transferencias con estado " + estado);
        }
    }

    // METODOS DE VALIDACION
    private LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String fechaStr = scanner.nextLine();
            try {
                return LocalDate.parse(fechaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha invalido. Use dd/mm/aaaa");
            }
        }
    }

    private boolean validarIdBanner(String id) {
        if (id == null || id.length() != 9) return false;
        if (!id.startsWith("A")) return false;
        String numeros = id.substring(1);
        for (char c : numeros.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // METODO PRINCIPAL DEL MENU
    private void prestarLibro() {
        System.out.println("\n=== PRESTAR LIBRO ===");

        String codigoUsuario;
        while (true) {
            System.out.print("Ingrese su codigo de usuario (ID Banner - Formato A00000000): ");
            codigoUsuario = scanner.nextLine().trim().toUpperCase();

            if (validarIdBanner(codigoUsuario)) {
                break;
            }
            System.out.println("ID Banner invalido. Debe comenzar con 'A' seguido de 8 digitos.");
            System.out.print("Desea intentar de nuevo? (S/N): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                return;
            }
        }

        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado en el sistema.");
            return;
        }

        if (!usuario.isPuedePrestar()) {
            System.out.println("Penalizacion por falta de puntualidad: No Procede al prestamo");
            System.out.println("Fecha fin de penalizacion: " + usuario.getFechaFinPenalizacion());
            return;
        }

        System.out.println("Usuario validado: " + usuario.getNombre() + " (" + usuario.getTipo() + ")");

        char continuarPrestamo = 'S';
        do {
            System.out.println("\n--- NUEVO PRESTAMO ---");

            System.out.println("\nSeleccione sucursal:");
            System.out.println("1. Biblioteca Granados");
            System.out.println("2. Biblioteca Park");
            System.out.print("Opcion: ");
            int opcionSucursal = scanner.nextInt();
            scanner.nextLine();

            String sucursal = (opcionSucursal == 1) ? "Biblioteca Granados" : "Biblioteca Park";

            System.out.println("\nLibros disponibles en " + sucursal + ":");
            listarLibrosDisponiblesPorSucursal(sucursal);

            System.out.print("\nIngrese el ISBN del libro que desea: ");
            String isbn = scanner.nextLine();

            Libro libro = buscarLibro(isbn);
            if (libro == null || !libro.getSucursal().equals(sucursal) || !libro.isDisponible()) {
                System.out.println("Libro no disponible en esta sucursal");
                System.out.print("Desea intentar con otro libro? (S/N): ");
                continuarPrestamo = scanner.nextLine().toUpperCase().charAt(0);
                continue;
            }

            System.out.println("\nSeleccione el plazo de prestamo:");
            System.out.println("1. 1 semana");
            System.out.println("2. 2 semanas");
            System.out.println("3. 1 mes");
            System.out.print("Opcion: ");
            int plazo = scanner.nextInt();
            scanner.nextLine();

            int semanas = 0;
            switch (plazo) {
                case 1: semanas = 1; break;
                case 2: semanas = 2; break;
                case 3: semanas = 4; break;
                default:
                    System.out.println("Opcion no valida");
                    return;
            }

            LocalDate fechaActual = LocalDate.now();
            realizarPrestamo(usuario, libro, fechaActual, semanas);

            System.out.print("\nDesea prestar otro libro? (S/N): ");
            continuarPrestamo = scanner.nextLine().toUpperCase().charAt(0);

        } while (continuarPrestamo == 'S');
    }

    private void entregarLibro() {
        System.out.println("\n=== ENTREGA LIBRO ===");
        System.out.print("Ingrese su codigo de usuario (ID Banner): ");
        String codigoUsuario = scanner.nextLine();

        listarPrestamosPendientesUsuario(codigoUsuario);

        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();

        LocalDate fechaDevolucion = leerFecha("Ingrese la fecha de devolucion (dd/mm/aaaa): ");

        devolverLibro(codigoUsuario, isbn, fechaDevolucion);
    }

    private void solicitarTransferenciaMenu() {
        System.out.println("\n=== SOLICITAR TRANSFERENCIA ===");

        System.out.print("Ingrese su codigo de usuario (ID Banner): ");
        String codigoUsuario = scanner.nextLine();

        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.println("\nSucursales disponibles:");
        System.out.println("1. Biblioteca Granados");
        System.out.println("2. Biblioteca Park");
        System.out.print("Seleccione sucursal destino: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        String sucursalDestino = (opcion == 1) ? "Biblioteca Granados" : "Biblioteca Park";

        System.out.println("\nLibros disponibles en el sistema:");
        listarLibrosDisponibles();

        System.out.print("Ingrese el ISBN del libro que desea transferir: ");
        String isbn = scanner.nextLine();

        solicitarTransferencia(codigoUsuario, isbn, sucursalDestino);
    }

    private void gestionarTransferenciasMenu() {
        System.out.println("\n=== GESTIONAR TRANSFERENCIAS ===");
        System.out.println("1. Listar todas las transferencias");
        System.out.println("2. Listar transferencias solicitadas");
        System.out.println("3. Listar transferencias en transito");
        System.out.println("4. Procesar transferencia (marcar como recibida)");
        System.out.println("5. Cancelar transferencia");
        System.out.print("Seleccione una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                listarTransferencias();
                break;
            case 2:
                listarTransferenciasPorEstado("SOLICITADA");
                break;
            case 3:
                listarTransferenciasPorEstado("EN_TRANSITO");
                break;
            case 4:
                System.out.print("Ingrese el codigo de transferencia: ");
                String codigoProcesar = scanner.nextLine();
                procesarTransferencia(codigoProcesar);
                break;
            case 5:
                System.out.print("Ingrese el codigo de transferencia: ");
                String codigoCancelar = scanner.nextLine();
                cancelarTransferencia(codigoCancelar);
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTION DE BIBLIOTECA ===");
            System.out.println("1. Ver Catalogo por Sucursal");
            System.out.println("2. Ver Libros Disponibles");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Entrega Libro");
            System.out.println("5. Solicitar Transferencia entre Sucursales");
            System.out.println("6. Gestionar Transferencias");
            System.out.println("7. Listar Multas");
            System.out.println("8. Listar Prestamos Activos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verCatalogoSucursal();
                    break;
                case 2:
                    verLibrosDisponibles();
                    break;
                case 3:
                    prestarLibro();
                    break;
                case 4:
                    entregarLibro();
                    break;
                case 5:
                    solicitarTransferenciaMenu();
                    break;
                case 6:
                    gestionarTransferenciasMenu();
                    break;
                case 7:
                    listarMultas();
                    break;
                case 8:
                    listarPrestamosActivos();
                    break;
                case 9:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 9);
    }

    private void verCatalogoSucursal() {
        System.out.println("\n--- VER CATALOGO POR SUCURSAL ---");
        System.out.println("1. Biblioteca Granados");
        System.out.println("2. Biblioteca Park");
        System.out.println("3. Ambas sucursales");
        System.out.print("Seleccione una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                listarLibrosPorSucursal("Biblioteca Granados");
                break;
            case 2:
                listarLibrosPorSucursal("Biblioteca Park");
                break;
            case 3:
                listarLibros();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private void verLibrosDisponibles() {
        System.out.println("\n--- LIBROS DISPONIBLES ---");
        listarLibrosDisponibles();
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

    public int getCantidadMultas() {
        return contadorMultas;
    }

    public int getCantidadTransferencias() {
        return contadorTransferencias;
    }
}