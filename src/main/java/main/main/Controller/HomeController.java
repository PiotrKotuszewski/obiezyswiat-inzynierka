package main.main.Controller;

import main.main.Service.EmployeeService;
import main.main.Service.TransactionService;
import main.main.Service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final EmployeeService employeeService;
    private final TransactionService transactionService;
    private final VehicleService vehicleService;

    public HomeController(EmployeeService employeeService, TransactionService transactionService,
                          VehicleService vehicleService) {
        this.employeeService = employeeService;
        this.transactionService = transactionService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String home(Model model, HttpServletRequest request){

        model.addAttribute("employeeList", employeeService.showAllEmployees());
        model.addAttribute("vehicleList", vehicleService.showAllVehicles());
        model.addAttribute("transactionList", transactionService.showAvailableTransactions());
        return "homePage";
    }
}
