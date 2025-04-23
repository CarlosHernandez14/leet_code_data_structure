package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T> {

    static class Node <T> {
        T value;
        Node<T> right;
        Node<T> left;

        Node(T value) {
            this.value = value;
        }
    }

    private int length;
    private Node<T> root;

    public BinarySearchTree() {}

    public BinarySearchTree(T value) {
        this.root = new Node<T>(value);
    }

    public boolean insert(T value) {
        Node<T> newNode = new Node<T>(value);
        if (root == null) {
            this.root = newNode;
            return true;
        }

        Node<T> temp = this.root;

        while (temp != null) {
            if (temp.value == newNode.value) return false;

            if ((Integer) newNode.value < (Integer)temp.value) {
                // Move left
                if (temp.left == null) {
                    temp.left = newNode;
                    temp = null;
                }
                else temp = temp.left;
            } else {
                // Move right
                if (temp.right == null) {
                    temp.right = newNode;
                    temp = null;
                }
                else temp = temp.right;
            }

        }

        return true;
    }

    public boolean contains(T value) {
        if (this.root == null) return false;

        Node<T> temp = this.root;

        while(temp != null) {
            if (temp.value == value) return true;

            temp = ((Integer) value < (Integer) temp.value) ? temp.left : temp.right;
        }

        return false;
    }

    public ArrayList<T> BFS() {
        ArrayList<T> result = new ArrayList<>();
        Node<T> currentNode = this.root;
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.peek();
            // Add the child nodes of the head of the queue
            if(currentNode.left != null)
                queue.add(currentNode.left);
            if(currentNode.right != null)
                queue.add(currentNode.right);
            // Remove the head of the queue
            result.add(queue.poll().value);
        }

        return result;
    }

    public ArrayList<T> DFSPreOrder() {
        ArrayList<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null)
                    new Traverse(currentNode.left);
                if (currentNode.right != null)
                    new Traverse(currentNode.right);
            }
        }

        new Traverse(this.root);

        return results;
    }

    public ArrayList<T> DFSPostOrder() {
        ArrayList<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> currentNode) {
                if (currentNode.left != null)
                    new Traverse(currentNode.left);
                if (currentNode.right != null)
                    new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }

        new Traverse(this.root);

        return results;
    }

    public ArrayList<T> DFSInOrder() {
        ArrayList<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> currentNode) {
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                results.add(currentNode.value);
                if (currentNode.right != null)
                    new Traverse(currentNode.right);
            }
        }

        new Traverse(this.root);

        return results;
    }

    public Integer kthSmallest(int k) {

        Stack<Integer> stack = new Stack<>();
        final Integer[] kSmallets = {null};
        class Traverse {
            Traverse(Node<T> currentNode) {
                if (currentNode.left != null)
                    new Traverse(currentNode.left);
                // Check for the parent node
                stack.push((Integer) currentNode.value);
                if (stack.size() == k)
                    kSmallets[0] = stack.peek();
                //Check for the right child
                if (currentNode.right != null)
                    new Traverse(currentNode.right);

            }
        }

        new Traverse(this.root);

        return kSmallets[0];
    }

    public boolean isValidBST() {

        Stack<Integer> stack = new Stack<>();
        final Boolean[] isValid = {true};
        class Traverse {
            Traverse(Node<T> currentNode) {
                if (currentNode.left != null)
                    new Traverse(currentNode.left);
                // Check for the parent node
                if (!stack.isEmpty() && (Integer) currentNode.value < (Integer) stack.peek())
                    isValid[0] = false;
                //Check for the right child
                if (currentNode.right != null)
                    new Traverse(currentNode.right);

            }
        }

        new Traverse(this.root);

        return isValid[0];

    }



}
