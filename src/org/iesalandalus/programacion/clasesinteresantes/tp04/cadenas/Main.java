package org.iesalandalus.programacion.clasesinteresantes.tp04.cadenas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Main {

    public static void main(String[] args) {

        String texto;
        do {
            System.out.print("Introduce el texto a aplicarle el algoritmo de Karaca: ");
            texto = Entrada.cadena();
            if (!texto.matches(Karaca.ER_TEXTO)) {
                System.out.println("El texto no cumple con el patrón especificado.");
            }
        } while (!texto.matches(Karaca.ER_TEXTO));

        Karaca karaca = new Karaca();
        String resultado = karaca.aplicar(texto);

        System.out.printf("Aplicar el algoritmo de Karaca al texto: %s, da como resultado: %s%n", texto, resultado);
    }
}
