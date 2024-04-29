package numeros;

import java.io.*;

public class Metodos {
    public static void escribirNumeros() {
        try (FileOutputStream fos = new FileOutputStream("numeros.dat")) {

            byte[] numeros = {10, 5, 3, 8, 6, 15};
            fos.write(numeros);
            System.out.println("Números escritos correctamente.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void separarNumeros() {
        try (FileInputStream fis = new FileInputStream("numeros.dat");
             FileOutputStream paresFos = new FileOutputStream("pares.dat");
             FileOutputStream imparesFos = new FileOutputStream("impares.dat")) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                if (byteLeido % 2 == 0) {
                    paresFos.write(byteLeido);
                } else {
                    imparesFos.write(byteLeido);
                }
            }

            System.out.println("Números separados correctamente.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void mostrarFicheros() {
        mostrarFichero("pares.dat");
        mostrarFichero("impares.dat");
    }

    public static void mostrarFichero(String nombreFichero) {
        try (FileInputStream fis = new FileInputStream(nombreFichero)) {
            System.out.println("Contenido de " + nombreFichero + ":");
            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                System.out.println(byteLeido);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreFichero + ": " + e.getMessage());
        }
    }
}