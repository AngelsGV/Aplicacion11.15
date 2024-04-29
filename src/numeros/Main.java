package numeros;

import static numeros.Metodos.*;

// Crea un programa que lea números enteros desde el fichero numeros.dat y los vaya guardando en los ficheros pares.dat
// e impares.dat según su paridad. Añade la función para mostrar los datos de los
// ficheros pares.dat e impares.dat para comprobar que se han guardado correctamente.
public class Main {
    public static void main(String[] args) {

        // Crear y escribir números
        escribirNumeros();
        // Separar números en pares y impares
        separarNumeros();

        mostrarFicheros();
    }
}