/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;


/**
 *
 * @author pkuma
 */
public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // References the first node in the chain
    
    //default constructor
    public LinkedStack() {
        initializeDataFields();
    } // end default constructor
    
    private void initializeDataFields() {
        topNode = null;
    }

    /** Adds a new entry to the top of this stack.
       @param newEntry  An object to be added to the stack. */
    @Override
    public void push(T newEntry) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Node newNode = new Node(newEntry);
        if(topNode == null) {
            topNode = newNode;
        }
        else {
            newNode.next = topNode;
            topNode = newNode;
        }
    }

    /** Removes and returns this stack's top entry.
       @return  The object at the top of the stack. 
       @throws  EmptyStackException if the stack is empty before the operation. */
    @Override
    public T pop() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        T topEntry = null;
        if(topNode == null) {
            throw new EmptyStackException("The stack is empty.");
        }
        else {
            topEntry = topNode.getData();
            topNode = topNode.next;
        }
        return topEntry;
    }

    /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
    @Override
    public T peek() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(topNode == null) {
            throw new EmptyStackException("The stack is empty.");
        }
        else {
            return topNode.getData();
        }
    }

    /** Detects whether this stack is empty.
       @return  True if the stack is empty. */
    @Override
    public boolean isEmpty() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(topNode == null) {
            return true;
        }
        return false;
    }

    /** Removes all entries from this stack. */
    @Override
    public void clear() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        topNode = null;
    }
    
    
    private class Node {

        private T data; // entry in bag
        private Node next; // link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        } // end getData

        private void setData(T newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
}