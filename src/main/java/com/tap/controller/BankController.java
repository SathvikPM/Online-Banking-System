package com.tap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.dao.AccountDAO;
import com.tap.dao.UserDAO;
import com.tap.model.Account;
import com.tap.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
public class BankController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AccountDAO accountDAO;
    
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        System.out.println("Entering home");
        model.addAttribute("message", "Welcome to Online Banking!");
        return "home"; // Loads home.jsp
    }

    @GetMapping("/login")
    public String showLoginPage() {
        System.out.println("Inside showLoginPage method - Login page requested");
        return "login";
    }

    @PostMapping("/bankLogin")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("Logging in User: " + email);
        model.addAttribute("user", email);
        return "dashboard"; // Change to your actual dashboard view
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        System.out.println("Inside showRegisterPage method - Register page requested");
        return "register";
    }

    

    @GetMapping("/BankAccount")
    public String showAccountPage() {
        System.out.println("Inside showRegisterPage method - Register page requested");
        return "account";
    }

    @PostMapping("/account")
    public String createAccount(@ModelAttribute("account") Account account, Model model) {
        accountDAO.saveAccount(account);
        model.addAttribute("account", account);
        return "dashboard"; // Redirects to the success page
    }
}
