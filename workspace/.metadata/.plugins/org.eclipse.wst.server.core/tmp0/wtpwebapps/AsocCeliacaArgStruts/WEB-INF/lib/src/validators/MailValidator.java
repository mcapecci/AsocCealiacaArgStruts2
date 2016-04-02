package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "mailValidator")
public class MailValidator implements Validator {

	public void validate(FacesContext fc, UIComponent component, Object value)
			throws ValidatorException {
		String strValue = String.valueOf(value);
		if (!strValue.matches(".+@.+\\.[a-z]+")){
			throw new ValidatorException(new FacesMessage("Formato de mail incorrecto"));
		}
	}
}

