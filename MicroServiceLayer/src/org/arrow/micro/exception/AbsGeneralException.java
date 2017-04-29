package org.arrow.micro.exception;

public class AbsGeneralException extends Exception{
	
	public String ErrorMessage;
	public String Errocode;
	
	public AbsGeneralException(String ErrorMessage, String Errorcode){
		this.ErrorMessage = ErrorMessage;
		this.Errocode = Errorcode;
	}

}
