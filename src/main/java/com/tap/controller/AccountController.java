
package com.tap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tap.model.Account;
import com.tap.model.Transaction;
import com.tap.model.User;
import com.tap.service.AccountService;
import com.tap.service.TransactionService;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/viewAccounts")
    public String viewAccounts(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userLogin";
        }

        int userId = user.getUserId();
        List<Account> accounts = accountService.getAccountsByUserId(userId);
        model.addAttribute("accounts", accounts);

        return "viewAccounts";
    }

    @GetMapping("/viewAccountTransactions")
    public String viewAccountTransactions(@RequestParam int accountId, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/userLogin";
        }

        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        model.addAttribute("transactions", transactions);
        model.addAttribute("accountId", accountId);
        return "viewTransactions";
    }

    @GetMapping("/welcome")
    public String welcomeFile() {
        return "welcome";
    }
}
