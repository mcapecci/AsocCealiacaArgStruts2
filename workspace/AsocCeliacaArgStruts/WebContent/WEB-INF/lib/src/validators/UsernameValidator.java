package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import servicios.ValidatorService;

@FacesValidator(value = "usernameValidator")
public class UsernameValidator implements Validator {

	public void validate(FacesContext fc, UIComponent component, Object value)throws ValidatorException {
		String username = String.valueOf(value);
		ValidatorService serv = new ValidatorService();		
		if (serv.existeUsername(username)){
			throw new ValidatorException(new FacesMessage("El nombre de usuario ya existe"));
		}
	}
}