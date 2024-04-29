package numeros;

import java.io.*;

public class Metodos {
    public static void escribirNumeros() {
        //Para ver si el ejercicio esta bien, tengo que crear el archivo numeros.dat y llenarlo
        //Así podremos ver si las respuestas de pares e impares son OK
        try (ObjectOutputStream flujoSalida = new  ObjectOutputStream(new FileOutputStream("numeros.dat"))) {
            int[] numeros = {12, 5, 3, 8, 6, -9};
            for (int t: numeros) {//Se recorre el vector y se escriben el el doc 1 a 1 como tipo int
                flujoSalida.writeInt(t);
            }
            System.out.println("Números escritos correctamente.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void separarNumeros() {

        try (ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("numeros.dat"));
             ObjectOutputStream pares = new ObjectOutputStream(new FileOutputStream("pares.dat"));
            ObjectOutputStream impares = new ObjectOutputStream(new FileOutputStream("impares.dat"))) {

            int numero;
            while (true) {//Pongo true por poner algo. No sabia que condición poner
                try {
                    numero = flujoEntrada.readInt();
                    if (numero % 2 == 0) { //Si es multiplo de 2. Par.
                        pares.writeInt(numero);
                    } else {
                        impares.writeInt(numero);//Si queda resto al dividir entre 2. Impar.
                    }
                } catch (Exception ex) {
                    break; // Salir del bucle cuando se llega al final del archivo
                }
            }

            System.out.println("Números separados correctamente.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void mostrarFichero(String nombreFichero) {
        try (ObjectInputStream fichero = new ObjectInputStream(new FileInputStream(nombreFichero))) {

            //He encontado esta solución después de ya marearme de input i output
            System.out.println("Contenido de " + nombreFichero + ":");
            int numero;
            while (fichero.available() > 0) {
                numero = fichero.readInt();
                System.out.println(numero);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
//---------------------------------------------
//PROBLEMAS:
//En la solución del programa me da la respuenta con un monton de 0