/*
package main.main.Controller;

import main.main.Model.User;
import main.main.Service.EmployeeService;
import main.main.Service.UserService;
import main.main.ValidatingFormInput.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginUserController implements WebMvcConfigurer {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("homePage");
        //Place for after login controller
    }

    @GetMapping("/")
    String entry(User user) {
        return "login";
    }

    @PostMapping("/")
    String userLogin(User user, BindingResult bindingResult) {
        User dbUser = userService.getUserByEmail(user.getEmail());

        System.out.println(dbUser);
        if (dbUser == null) {
            bindingResult.rejectValue("email", "error.User", "An account don't exists for this email.");
            return "login";
        } else {
            System.out.println(userService.checkPassword(user.getPassword(),dbUser.getPassword()));
            if (!userService.checkPassword(user.getPassword(),dbUser.getPassword())){
                bindingResult.rejectValue("password", "error.User", "This is not correct password for this account");
                return "login";
            }else {
                return "homePage";
            }
        }
    }
}
*/
