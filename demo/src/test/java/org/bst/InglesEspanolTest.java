package org.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InglesEspanolTest {

    private BinaryTree<Association<String, String>> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree<>();
        tree.insert(new Association<>("house", "casa"));
        tree.insert(new Association<>("cat", "gato"));
        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("car", "carro"));
        tree.insert(new Association<>("tree", "árbol"));
    }

    // PRUEBA UNITARIA DE INSERT
    @Test
    public void testInsertarElemento_yLuegoSePuedeBuscar() {
        tree.insert(new Association<>("book", "libro"));

        Association<String, String> result = tree.search(new Association<>("book", null));
        Assertions.assertNotNull(result);
        Assertions.assertEquals("libro", result.getValue());
    }

    @Test
    public void testInsertarDuplicado_lanzaExcepcion() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tree.insert(new Association<>("cat", "gato2"));
        });
    }

    // PRUEBAS UNITARIAS DE SEARCH 
    @Test
    public void testBuscarPalabraExistente() {
        Association<String, String> result = tree.search(new Association<>("cat", null));
        Assertions.assertNotNull(result);
        Assertions.assertEquals("gato", result.getValue());
    }

    @Test
    public void testBuscarPalabraNoExistente() {
        Association<String, String> result = tree.search(new Association<>("bird", null));
        Assertions.assertNull(result);
    }
}