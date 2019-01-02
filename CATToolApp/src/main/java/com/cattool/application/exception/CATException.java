package com.cattool.application.exception;

public class CATException extends Exception{
	
	private static String ExceptionMessage;
   
	private static final long serialVersionUID = 1860734129029308300L;
	
	public CATException(String message)
	{
		this.ExceptionMessage=message;
	}
}
