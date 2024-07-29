package Gestion_Esfot;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para generar un hash SHA-256 de una cadena de texto.
 */

public class Encriptar {

    /**
     * Genera un hash SHA-256 de la entrada proporcionada.
     *
     * @param input Cadena de texto a ser encriptada.
     * @return Hash en formato hexadecimal.
     */

    public static String generateHash(String input) {
        try {
            // Crear un objeto MessageDigest con el algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes());
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     *
     * @param hash Arreglo de bytes a convertir.
     * @return Cadena hexadecimal representando el hash.
     */

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        // Convertir cada byte en una representación hexadecimal
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


}

