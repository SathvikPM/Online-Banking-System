package com.tap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.dao.UserDAO;
import com.tap.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/userLogin")
    public String showUserLoginPage() {
        System.out.println("Inside showUserLoginPage method - User Login page requested");
        return "login"; // Loads login.jsp
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("Logging in User: " + email);

        // Add login logic here, e.g., verify credentials against database
        User user = userDAO.getUserByEmailAndPassword(email, password);
        if (user == null) {
            model.addAttribute("error", "Invalid email or password.");
            return "login"; // Redirect back to the login page
        }

        // If successful, set user in session and redirect to dashboard
        session.setAttribute("user", user);
        return "welcome"; // Change to your actual user dashboard view
    }

    @GetMapping("/userRegister")
    public String showUserRegisterPage() {
        System.out.println("Inside showUserRegisterPage method - User Register page requested");
        return "register"; // Loads register.jsp
    }

    @PostMapping("/processUserRegister")
    public String processUserRegister(@ModelAttribute User user, HttpSession session, Model model) {
        System.out.println("Registering User: " + user.getName() + ", " + user.getEmail());

        // Check if email already exists
        if (userDAO.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already in use. Please use a different email.");
            return "register"; // Redirect back to the register page
        }

        // Save user to the database
        userDAO.saveUser(user);

        // Add user to model for success page
        session.setAttribute("user", user);
        model.addAttribute("user", user);
        model.addAttribute("userId", user.getUserId());

        return "register-success"; // Redirects to the success page
    }


    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        System.out.println("Inside showDashboard method - Dashboard page requested");

        // Ensure user is logged in
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userLogin"; // Redirect to login page if user is not logged in
        }

        // Add logic to prepare the dashboard view
        model.addAttribute("user", user);

        return "dashboard"; // Loads dashboard.jsp
    }
}
