package org.bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class TXTReader {
    // Para todo archivo txt
    public String leerArchivo(File ruta) {
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return contenido.toString();
    }
    // Unicamente para el diccionario para evitar duplicados
    public String leerDiccionario(File ruta) {
        StringBuilder contenido = new StringBuilder();
        Set<String> seen = new HashSet<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                linea = linea.replace("(", "").replace(")", "").trim();
                String[] parts = linea.split(",", 2);
                if (parts.length != 2) continue;

                String english = parts[0].trim().toLowerCase();

                if (seen.add(english)) {
                    contenido.append(linea).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return contenido.toString();
    }
}