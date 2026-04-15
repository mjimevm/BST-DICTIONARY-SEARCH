package org.bst;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> {

    private static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;
        Node(E data) { 
            this.data = data; 
        }
    }

    private Node<E> root;

    public void insert(E data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }
    }

    private void insert(E data, Node<E> node) {
        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node<>(data);
            } else {
                insert(data, node.left);
            }
        } else if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node<>(data);
            } else {
                insert(data, node.right);
            }
        } else {
            throw new IllegalArgumentException("Duplicado en BST: " + data);
        }
    }

    public E search(E data) {
        return search(data, root);
    }

    private E search(E data, Node<E> node) {
        if (node == null) {
            return null;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return search(data, node.left);
        }
        if (cmp > 0) {
            return search(data, node.right);
        }
        return node.data;
    }

    public List<E> inOrder() {
        List<E> out = new ArrayList<>();
        inOrder(root, out);
        return out;
    }

    private void inOrder(Node<E> node, List<E> out) {
        if (node == null) return;
        inOrder(node.left, out);
        out.add(node.data);
        inOrder(node.right, out);
    }
}