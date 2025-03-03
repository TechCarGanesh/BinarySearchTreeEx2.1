/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtreeex2;

/**
 *
 * @author pk914828
 */

/**
   A class of runtime exceptions thrown by methods to
   indicate that a tree is empty.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.2
 */
public class EmptyTreeException extends RuntimeException
{
	public EmptyTreeException()
	{
		this(null);
	} // end default constructor

	public EmptyTreeException(String message)
	{
		super(message);
	} // end constructor
} // end EmptyTreeException
