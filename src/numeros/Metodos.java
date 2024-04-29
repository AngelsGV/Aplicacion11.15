package numeros;

import java.io.*;

public class Metodos {
    public static void escribirNumeros() {
            try (ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("numeros.dat"))) {
                int[] numeros = {10, 5, 3, 8, 6, 1};
                flujoSalida.writeObject(numeros);
            //Me lio con entrada i salida. La salida es para escritura como en este caso.
            //Nos interesa que se cree algo en el archivo para ver si funciona.

            System.out.println("Números escritos correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void separarNumeros() {

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("numeros.dat"));
             BufferedWriter paresWriter = new BufferedWriter(new FileWriter("pares.dat"));
             BufferedWriter imparesWriter = new BufferedWriter(new FileWriter("impares.dat"))) {

            Object obj;
            while ((obj = flujoEntrada.readObject()) != null) {
                int numero = (Integer) obj;
                if (numero % 2 == 0) {
                    paresWriter.write(String.valueOf(numero));
                    paresWriter.newLine();
                } else {
                    imparesWriter.write(String.valueOf(numero));
                    imparesWriter.newLine();
                }
            }

            System.out.println("Números separados correctamente en pares.dat e impares.dat.");
        } catch (EOFException e) {
            System.out.println("Fin de archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    public static void mostrarFicheros() {
        mostrarFichero("pares.dat");
        mostrarFichero("impares.dat");
    }

    public static void mostrarFichero(String nombreFichero) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
            System.out.println("Contenido de " + nombreFichero + ":");
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo " + nombreFichero + ": " + e.getMessage());
        }
    }
}