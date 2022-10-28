package Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.Entity.Users;
import com.example.demo.Service.UserService;

@Component
public class Validations implements Validator {
	
	@Autowired
	UserService userService;

	

	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Users user = (Users) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length()<6 || user.getUsername().length()>32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if(userService.findByUserName(user.getUsername())!= null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
        }
		
		
		
	}

}
