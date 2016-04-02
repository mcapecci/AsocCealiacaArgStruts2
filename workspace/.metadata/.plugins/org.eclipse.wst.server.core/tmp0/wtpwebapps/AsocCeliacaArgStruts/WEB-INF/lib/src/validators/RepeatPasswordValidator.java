package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "repeatPasswordValidator")
public class RepeatPasswordValidator  implements Validator {

	public void validate(FacesContext fc, UIComponent component, Object value)
			throws ValidatorException {

		String pass = (String) component.getAttributes().get("password");
		System.out.println(pass);
		System.out.println(value);
		if (!value.equals(pass)) {
			FacesMessage message = new FacesMessage();
			message.setSummary("La contraseña no coincide");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}


}
