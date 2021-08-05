package infy.library.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DateValidation implements Validator{
	
	/* This method is a custom validator method.
	 * It will check the entered date is greater than today's date
	 * @param: javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object
	 * @return: void
	 * @throws: ValidatorException
	 */

	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)throws ValidatorException {
		
		Date enterDate=(Date)arg2;
		Date today=new Date();
		if(enterDate.after(today)){
			FacesMessage message=new FacesMessage();
			message.setDetail("Date cannot be greater than today's date");
			throw new ValidatorException(message);
		}
	}
}
