package pe.edu.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios.
 * Proporciona funcionalidad para registrar y validar usuarios.
 */
public class UserRegistrationService {

    /** Mensaje del último error ocurrido. */
    private String lastErrorMessage = "";

    /** Lista de usuarios registrados. */
    private List<String> users = new ArrayList<>();

    /** Longitud mínima de contraseña. */
    private static final int MIN_PASSWORD_LENGTH = 8;

    /**
     * Constructor del servicio de registro.
     */
    public UserRegistrationService() {
        this.users = new ArrayList<>();
        this.lastErrorMessage = "";
    }

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param username nombre del usuario
     * @param password contraseña del usuario
     * @param email correo electrónico del usuario
     * @return true si el registro fue exitoso, false en caso contrario
     */
    public final boolean registerUser(final String username,
                                      final String password,
                                      final String email) {
        // Validar username
        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        // Validar password
        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        // Validar email
        if (email == null || !email.contains("@") || !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no es válido.";
            return false;
        }

        // Intentar guardar usuario
        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            lastErrorMessage = "Error al guardar: " + e.getMessage();
            System.err.println("Error: " + e.getMessage());
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    /**
     * Guarda un usuario en la lista interna.
     *
     * @param username nombre del usuario
     * @param password contraseña del usuario
     * @param email correo electrónico
     * @throws Exception si el usuario no es permitido
     */
    private void saveUser(final String username,
                          final String password,
                          final String email) throws Exception {
        users.add(username);

        if ("error".equals(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }
    }

    /**
     * Calcula la longitud de una cadena de forma segura.
     *
     * @param input cadena de entrada
     * @return longitud de la cadena, -1 si es null
     */
    public final int calculateStringLength(final String input) {
        if (input == null) {
            return -1;
        }
        return input.length();
    }

    /**
     * Obtiene el mensaje del último error.
     *
     * @return mensaje de error
     */
    public final String getLastErrorMessage() {
        return lastErrorMessage;
    }
}

