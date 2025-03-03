/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;


/**
 *
 * @author pkuma
 */
public final class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode; // references node at front of queue
    private Node lastNode; // references node at back of queue
    
    // Constructor
    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor
    
    /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
    @Override
    public void enqueue(T newEntry) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // Creating an instance of a node called newNode.
        // Add entry information to newNode.
        Node newNode = new Node(newEntry, null);

        // If queue is empty, add it to the beginning of the queue.
        if (isEmpty()) {
            firstNode = newNode;
        }
        else {
            lastNode.setNextNode(newNode);
        }

        lastNode = newNode;
    }

    /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
    @Override
    public T dequeue() {
        // throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        T front = null;
        if (!isEmpty())
        {
            front = firstNode.getData();
            firstNode = firstNode.getNextNode();
            
            if (firstNode == null) {
                lastNode = null;
            }
        }
        else {
            // If the queue is empty, throw an exception.
            throw new EmptyQueueException("Queue is empty.");
        }

        return front;
    }

    /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
    @Override
    public T getFront() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        T front = null;
        if (!isEmpty()) {
            front = firstNode.getData();
        }
        else {
            // If the queue is empty, throw an exception.
            throw new EmptyQueueException("Queue is empty.");
        }
        return front;
    }

    /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
    @Override
    public boolean isEmpty() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (firstNode == null) && (lastNode == null);
    }

    /** Removes all entries from this queue. */
    @Override
    public void clear() {
        // throw new UnsupportedOperationException("Not supported yet.");
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        firstNode = null;
        lastNode = null;
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
