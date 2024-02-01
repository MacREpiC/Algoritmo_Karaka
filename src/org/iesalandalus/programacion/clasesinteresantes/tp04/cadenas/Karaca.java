package org.iesalandalus.programacion.clasesinteresantes.tp04.cadenas;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Karaca {
    public static final String ER_TEXTO = "[qwrtypsdfghjklñzxcvbnm0-4]+(?: [qwrtypsdfghjklñzxcvbnm0-4]+)*ACA|[a-z]+(?: [a-z]+)*";
    /* Expresión regular principal:
    public static final String ER_TEXTO = "[a-z]+(?: [a-z]+)*|[a-z]0-4]+(?: [[a-z]0-4]+)*aca";
    */
    public static final String CONTROL = "ACA";

    public String aplicar(String texto) {
        validarTexto(texto);

        if (texto.endsWith(CONTROL) && texto.length() > CONTROL.length() && contieneDigitos(texto)) {
            return decodificar(texto);
        } else {
            return codificar(texto);
        }
    }

    private void validarTexto(String texto) {
        Pattern pattern = Pattern.compile(ER_TEXTO);
        Matcher matcher = pattern.matcher(texto);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("El texto no empareja con el patrón regular.");
        }
    }

    private boolean contieneDigitos(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private void reemplazar(StringBuilder cadena, String vieja, String nueva) {
        int index = cadena.indexOf(vieja);
        while (index != -1) {
            cadena.replace(index, index + vieja.length(), nueva);
            index = cadena.indexOf(vieja, index + nueva.length());
        }
    }

    private String codificar(String texto) {
        StringBuilder resultado = new StringBuilder(texto).reverse();
        reemplazar(resultado, "a", "0");
        reemplazar(resultado, "e", "1");
        reemplazar(resultado, "i", "2");
        reemplazar(resultado, "o", "3");
        reemplazar(resultado, "u", "4");
        resultado.append(CONTROL);
        return resultado.toString();
    }

    private String decodificar(String texto) {
        StringBuilder resultado = new StringBuilder(texto.substring(0, texto.length() - CONTROL.length())).reverse();
        reemplazar(resultado, "0", "a");
        reemplazar(resultado, "1", "e");
        reemplazar(resultado, "2", "i");
        reemplazar(resultado, "3", "o");
        reemplazar(resultado, "4", "u");
        return resultado.toString();
    }
}
