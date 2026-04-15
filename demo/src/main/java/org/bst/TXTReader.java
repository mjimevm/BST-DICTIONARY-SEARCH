package org.bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTReader {
    public String leerArchivo(File ruta) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
            if (contenido.toString().contains("(") || contenido.toString().contains(")")) {
                StringBuilder contenidoSinParentesis = new StringBuilder();
                for (char c : contenido.toString().toCharArray()) {
                    if (c != '(' && c != ')') {
                        contenidoSinParentesis.append(c);
                    }
                }
                return contenidoSinParentesis.toString();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }
}