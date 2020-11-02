package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Transaction;
import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final EmployeeService employeeService;

    public TransactionController(TransactionService transactionService, EmployeeService employeeService) {
        this.transactionService = transactionService;
        this.employeeService = employeeService;
    }

    @GetMapping("/allTransactions")
    public String showTransactions(Model model){
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "availableTransaction";
    }

    @GetMapping("/acceptTransaction")
    public String applyTransaction(Model model){
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "acceptTransaction";
    }

    public String acceptTransaction(@ModelAttribute @Valid Transaction transaction, Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "acceptTransaction";
        else{

            return "homePage";
        }
    }

    @GetMapping("/transaction/getOne")
    @ResponseBody
    public Optional<Transaction> getOne(Long Id){
        return transactionService.getOne(Id);
    }

    @RequestMapping("/transaction/assign")
    public String assignTransaction(Transaction transaction, Long Id){
        transactionService.assign(transaction, Id);
        return "redirect:/acceptTransaction";
    }
}
