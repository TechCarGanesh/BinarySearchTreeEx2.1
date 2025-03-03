/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author Ganesh Kumar
 */
/**
   A class of runtime exceptions thrown by methods to
   indicate that a queue is empty.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class EmptyQueueException extends RuntimeException
{
   public EmptyQueueException()
   {
      this(null);
   } // end default constructor
   
   public EmptyQueueException(String message)
   {
      super(message);
   } // end constructor
} // end EmptyQueueException