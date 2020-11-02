package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;


@RequestMapping("/employee")
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public String showEmployees(Model model, HttpServletRequest request){
        model.addAttribute("employeeList", employeeService.showAllEmployees());
        return "employee";
    }

    @GetMapping("/addEmployee")
    public String employee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute @Valid Employee employee, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()) {
            return "addEmployee";
        }else{
            employeeService.addEmployee(employee, new EmployeeDetails(0, 0f));
            return "homePage";
        }
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Optional<Employee> getOne(Long Id){
        return employeeService.getOne(Id);
    }

    @RequestMapping("/update")
    public String update(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/allEmployees";
    }

    @GetMapping("/delete")
    public String deleteEmployee(Long Id){
        employeeService.deleteEmployee(Id);
        return "redirect:/employee/allEmployees";
    }
}