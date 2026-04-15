package org.bst;
public class BinaryTree<E extends Comparable<E>> {
    private class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;
        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node<E> root;
    
    public BinaryTree() {
        this.root = null;
    }
    private void insert(E data, Node<E> root) {
        if (data.compareTo(root.data) < 0) {
            if (root.left == null) {
                root.left = new Node<>(data);
            } else {
                insert(data, root.left);
            }
        } else if (data.compareTo(root.data) > 0) {
            if (root.right == null) {
                root.right = new Node<>(data);
            } else {
                insert(data, root.right);
            }
        } else {
            throw new IllegalArgumentException("No se permite insertar valores duplicados en el árbol binario de búsqueda.");    
        }
    }
    public Node<E> getRoot() {
        return root;
    }
    public void insert(E data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }
    }
    public void search(E data) {
        search(data, root);
    }
    private void search(E data, Node<E> root) {
        if (root == null) {
            System.out.println("El valor " + data + " no se encuentra en el árbol.");
            return;
        }
        if (data.compareTo(root.data) < 0) {
            search(data, root.left);
        } else if (data.compareTo(root.data) > 0) {
            search(data, root.right);
        } else {
            System.out.println("El valor " + data + " se encuentra en el árbol.");
        }
    }
}
