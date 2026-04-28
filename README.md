# BST-DICTIONARY-SEARCH

Diccionario **Inglés a Español** usando un **Árbol Binario de Búsqueda (BST)**.  
El diccionario se carga desde `diccionario.txt` (asociaciones `(english, español)`) y luego se puede traducir una palabra, una frase o el contenido de `texto.txt`.

## Importante: ejecutar desde la carpeta `demo`
Este proyecto está organizado como un subproyecto dentro de la carpeta **`demo/`**.  
**Para que las rutas de los archivos funcionen correctamente, se debe ejecutar el programa desde `demo`.**

### Estructura relevante
- `demo/src/main/java/org/bst/Main.java` (programa principal)
- `demo/src/main/resources/diccionario.txt` (diccionario)
- `demo/src/main/resources/texto.txt` (texto a traducir)
- `demo/src/test/org/bst/IngesEspanolTest.java` (pruebas unitarias)

## ¿Cómo ejecutar?

### Desde terminal (recomendado)
1. Entrar a la carpeta `demo`:
   ```bash
   cd demo
   ```

2. Ejecutar con Maven:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="org.bst.Main"
   ```
   
## Funcionalidades
El programa imprime un menú con las siguientes opciones:
1. Traducir una palabra
2. Traducir el archivo `texto.txt`
3. Mostrar el diccionario completo ordenado (recorrido **in-order**)
4. Salir

## Notas
- La búsqueda en el diccionario **no distingue mayúsculas/minúsculas** (se convierte a minúsculas).
- Si una palabra no existe en el diccionario, se imprime en inglés entre asteriscos: `*word*`.

## Autor
Jimena Vásquez - 25092
