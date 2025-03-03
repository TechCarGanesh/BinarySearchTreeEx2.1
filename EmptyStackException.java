/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author Ganesh Kumar
 */
public class EmptyStackException extends RuntimeException
{
   public EmptyStackException()
   {
      this(null);
   } // end default constructor
   
   public EmptyStackException(String message)
   {
      super(message);
   } // end constructor
} // end EmptyStackException
