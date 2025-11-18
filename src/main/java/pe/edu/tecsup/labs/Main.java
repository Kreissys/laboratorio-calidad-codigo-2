package pe.edu.tecsup.labs;

/**
 * Clase principal para probar el servicio de registro.
 */
public final class Main {

    /**
     * Constructor privado para evitar instanciación.
     */
    private Main() {
        throw new UnsupportedOperationException("Clase utilitaria");
    }

    /**
     * Método principal de ejecución.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(final String[] args) {
        UserRegistrationService service = new UserRegistrationService();

        // Caso 1: Contraseña muy corta
        service.registerUser("juan", "123", "juan@correo.com");
        System.out.println("Error: " + service.getLastErrorMessage());

        // Caso 2: username null
        service.registerUser(null, "12345678", "correo@sinvalido.com");
        System.out.println("Error: " + service.getLastErrorMessage());

        // Caso 3: Forzar excepción
        service.registerUser("error", "12345678", "error@correo.com");
        System.out.println("Error: " + service.getLastErrorMessage());

        // Caso 4: Registro exitoso
        boolean exito = service.registerUser("usuario_valido",
                "password123", "usuario@correo.com");
        if (exito) {
            System.out.println("Usuario registrado exitosamente");
        }
    }
}

