package org.bst;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Rutas y TXTReader
        String ruta = "demo/src/main/resources/diccionario.txt";
        TXTReader reader = new TXTReader();
        String ruta2 = "demo/src/main/resources/texto.txt";

        Scanner teclado = new Scanner(System.in);

        String contenido = reader.leerArchivo(new File(ruta), false);
        String[] lineas = contenido.split("\n");
        BinaryTree<Association<String,String>> tree = new BinaryTree<>();

        for (String line : lineas) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                tree.insert(new Association<>(parts[0].trim(), parts[1].trim()));
            }
        }
        System.out.println(contenido);
        System.out.println("MENÚ:");
        System.out.println("1. Traducir palabra");
        System.out.println("2. Leer archivo texto.txt para traducir");
        System.out.println("3. Introducir frase para traducir");
        System.out.println("4. Salir");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                // Traducir palabra
                System.out.println("Introduce la palabra a traducir:");
                String palabra = teclado.next();
                Association<String, String> result = tree.search(new Association<>(palabra, null));
                if (result != null) {
                    System.out.println("Traducción: " + result.getValue());
                } else {
                    System.out.println("Palabra no encontrada.");
                }
                break;
            case 2:
                String frase = reader.leerArchivo(new File(ruta2), false);
                System.out.println("Frase introducida: " + frase);
                break;
            case 3:
                String frase2 = reader.leerArchivo(new File(ruta2), false);
                System.out.println("Frase introducida: " + frase2);
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}