package com.tap.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.tap.model.Account;
import com.tap.model.Transaction;
import com.tap.service.AccountService;
import com.tap.service.TransactionService;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/transaction")
    public String showTransactionPage() {
        return "transaction";
    }

    @PostMapping("/transaction")
    public String createTransaction(@RequestParam int accountId, @RequestParam String transactionType,
                                    @RequestParam double amount, Model model) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            model.addAttribute("error", "Invalid Account ID.");
            return "transaction";
        }

        Transaction transaction = new Transaction(0, account, transactionType, amount, new Timestamp(System.currentTimeMillis()));
        transactionService.saveTransaction(transaction);
        model.addAttribute("message", "Transaction recorded successfully!");

        return "transaction";
    }

    @GetMapping("/viewAccountTransactionDetails")
    public String viewAccountTransactionDetails(@RequestParam(name = "accountId", required = true) String accountIdStr, Model model) {
        if (accountIdStr == null || accountIdStr.trim().isEmpty()) {
            model.addAttribute("error", "Invalid Account ID.");
            return "viewTransactions";
        }

        Integer accountId = null;
        try {
            accountId = Integer.parseInt(accountIdStr.trim());
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid Account ID.");
            return "viewTransactions";
        }

        if (accountId == null || accountId <= 0) {
            model.addAttribute("error", "Invalid Account ID.");
            return "viewTransactions";
        }

        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        model.addAttribute("transactions", transactions);
        return "viewTransactions";
    }
}

