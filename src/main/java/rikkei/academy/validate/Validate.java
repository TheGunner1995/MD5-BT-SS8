package rikkei.academy.validate;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.ValidationUtils;
import rikkei.academy.model.User;
import org.springframework.validation.Errors;
import rikkei.academy.service.user.IUserService;

import java.util.Optional;

public class Validate {
    public void CheckValidate(User user, Errors error){
        if (user.getFirstName().trim().equals("")){
            error.rejectValue("firstName","firstName.first");
        }
       if (user.getLastName().trim().equals("")) {
            error.rejectValue("lastName","lastName.last");
        }
        if (user.getAge()<18){
            error.rejectValue("age", "age.age");
        }
       if (user.getPassword().trim().equals("")){
           error.rejectValue("password","Password.pass");
        } else if (user.getPassword().length()<5){
            error.rejectValue("password", "Password.pass");
        }
      if (user.getPhoneNumber().trim().equals("")){
            error.rejectValue("phoneNumber", "phoneNumber.phone");
        }

      if (user.getEmail().trim().equals("")){
            error.rejectValue("email", "email.email");
        }
    }

}
