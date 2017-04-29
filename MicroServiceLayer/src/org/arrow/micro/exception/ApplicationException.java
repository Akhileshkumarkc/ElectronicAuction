package org.arrow.micro.exception;

public class ApplicationException extends AbsGeneralException{

	public ApplicationException(String ErrorMessage, String Errorcode) {
		super(ErrorMessage, Errorcode);
	}


}
