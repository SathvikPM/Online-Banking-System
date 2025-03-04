
package com.tap.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tap.model.Account;
import com.tap.model.User;
import com.tap.service.AccountService;
import com.tap.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
public class BankController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("message", "Welcome to Online Banking!");
        return "home"; // Loads home.jsp
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/bankLogin")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("user", email);
        return "dashboard"; // Change to your actual dashboard view
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/BankAccount")
    public String showAccountPage() {
        return "account";
    }

    @PostMapping("/account")
    public String createAccount(@ModelAttribute Account account, Model model) {
        accountService.saveAccount(account);
        model.addAttribute("account", account);
        return "dashboard"; // Redirects to the success page
    }
}
