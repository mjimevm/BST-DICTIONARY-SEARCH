package org.bst;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dicRuta = "demo/src/main/resources/diccionario.txt";
        String txtRuta = "demo/src/main/resources/texto.txt";

        TXTReader reader = new TXTReader();
        Scanner teclado = new Scanner(System.in);

        // Construir BST con Association(ingles, español)
        String contenido = reader.leerDiccionario(new File(dicRuta));
        String[] lineas = contenido.split("\n");

        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        for (String line : lineas) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // quitar paréntesis si existen: (house, casa)
            line = line.replace("(", "").replace(")", "").trim();

            String[] parts = line.split(",");
            if (parts.length == 2) {
                String english = parts[0].trim().toLowerCase();
                String spanish = parts[1].trim();
                tree.insert(new Association<>(english, spanish));
            }
        }

        System.out.println("Diccionario ordenado (in-order):");
        System.out.println(ordenarDiccionario(tree));
        System.out.println();

        int llave = 1;

        while (llave == 1) {
            System.out.println("MENÚ:");
            System.out.println("1. Traducir palabra");
            System.out.println("2. Traducir archivo texto.txt");
            System.out.println("3. Introducir frase para traducir");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(teclado.nextLine().trim());

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la palabra a traducir: ");
                    String palabra = teclado.nextLine().trim();
                    traducirPalabra(tree, palabra);
                    break;
                
                case 2:
                    String frase = reader.leerArchivo(new File(txtRuta));
                    traducirFrase(tree, frase);
                    break;
                case 3:
                    System.out.print("Escribe la frase en inglés: ");
                    String frase1 = teclado.nextLine();
                    traducirFrase(tree, frase1);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    llave = 0;
                    break;

                default: System.out.println("Opción no válida.");
            }

            System.out.println();
        }
    }

    private static void traducirPalabra(BinaryTree<Association<String, String>> tree, String palabra) {
        String key = palabra.toLowerCase();
        Association<String, String> result = tree.search(new Association<>(key, null));

        if (result != null) {
            System.out.println("Traducción: " + result.getValue());
        } else {
            System.out.println("Traducción: *" + palabra + "*");
        }
    }

    private static void traducirFrase(BinaryTree<Association<String, String>> tree, String frase) {
        String[] palabras = frase.split(" ");
        StringBuilder traduccion = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.isBlank()) continue;

            String key = palabra.toLowerCase();
            Association<String, String> result = tree.search(new Association<>(key, null));

            if (result != null) {
                traduccion.append(result.getValue());
            } else {
                traduccion.append("*").append(palabra).append("*");
            }
            traduccion.append(" ");
        }

        System.out.println("Traducción: " + traduccion.toString().trim());
    }

    private static String ordenarDiccionario(BinaryTree<Association<String, String>> tree) {
        StringBuilder sb = new StringBuilder();
        for (Association<String, String> assoc : tree.inOrder()) {
            sb.append("(").append(assoc.getKey()).append(", ").append(assoc.getValue()).append(") ");
        }
        return sb.toString().trim();
    }
}