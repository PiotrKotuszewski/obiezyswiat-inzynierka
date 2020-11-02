package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Vehicle;
import main.main.Service.EmployeeService;
import main.main.Service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;
    private final EmployeeService employeeService;

    public VehicleController(VehicleService vehicleService, EmployeeService employeeService) {
        this.vehicleService = vehicleService;
        this.employeeService = employeeService;
    }

    @GetMapping("/allVehicles")
    public String showVehicles(Model model, HttpServletRequest request){
        model.addAttribute("vehiclesList", vehicleService.showAllVehicles());
        return "vehicle";
    }

    @GetMapping("/addVehicle")
    public String vehicle(Model model, HttpServletRequest request){
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("employeeList", employeeService.showEmployeesWithoutVehicle());
        return "addVehicle";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute @Valid Vehicle vehicle, @ModelAttribute Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addVehicle";
        }else{
            employeeService.updateEmployeeVehicle(employee.getId(), vehicle);
            vehicleService.addVehicle(vehicle, employee);
            return "redirect:/vehicle/allVehicles";
        }
    }

    @GetMapping("/getOne")
    @ResponseBody
    public Optional<Vehicle> getOne(Long Id){
        return vehicleService.getOne(Id);
    }

    @RequestMapping("/update")
    public String update(Vehicle vehicle){
        vehicleService.updateVehicle(vehicle);
        return "redirect:/vehicle/allVehicles";
    }

    @GetMapping("/delete")
    public String delete(Long Id){
        vehicleService.deleteVehicle(Id);
        return "redirect:/vehicle/allVehicles";
    }
}
