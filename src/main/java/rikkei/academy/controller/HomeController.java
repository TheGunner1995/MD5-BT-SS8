package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.User;
import rikkei.academy.service.user.IUserService;
import rikkei.academy.validate.Validate;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private IUserService userService;
    @GetMapping("/")
   public String listUser(Model model){
        model.addAttribute("listUser",userService.findAll());
        return "/home";
    }

    @GetMapping("register")
    public ModelAndView formRegister(){
        ModelAndView modelAndView = new ModelAndView("/register");
        modelAndView.addObject("registers", new User());
        return modelAndView;
    }

    @PostMapping("registers")
    public String Register(@Validated @ModelAttribute("registers") User user, BindingResult bindingResult){
        new Validate().CheckValidate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/register";
        }else {
            userService.save(user);
        }
        return "redirect:/";
    }

}
