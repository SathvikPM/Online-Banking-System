package com.tap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.dao.AccountDAO;
import com.tap.dao.TransactionDAO;
import com.tap.model.Account;
import com.tap.model.Transaction;
import com.tap.model.User;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class AccountController {

  

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @GetMapping("/viewAccounts")
    public String viewAccounts(HttpSession session, Model model) {
        // Ensure user is logged in
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userLogin"; // Redirect to login page if user is not logged in
        }

        int userId = user.getUserId();
      List<Account> accounts = accountDAO.getAccountsByUserId(userId);
        model.addAttribute("accounts", accounts);

        return "viewAccounts"; // Loads viewAccounts.jsp
    }

    @GetMapping("/viewAccountTransactions")
    public String viewAccountTransactions(@RequestParam int accountId, HttpSession session, Model model) {
        // Ensure user is logged in
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userLogin"; // Redirect to login page if user is not logged in
        }

        List<Transaction> transactions = transactionDAO.getTransactionsByAccountId(accountId);
        model.addAttribute("transactions", transactions);
        model.addAttribute("accountId", accountId); // Add accountId to model for displaying in the view
        return "viewTransactions"; // Loads viewTransactions.jsp
    }
    
    @GetMapping("/welcome")
    public String welcomeFile() {
        return "welcome";
    }
}
