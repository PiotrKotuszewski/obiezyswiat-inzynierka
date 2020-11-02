package main.main.Controller;

import main.main.Model.Employee;
import main.main.Model.Vehicle;
import main.main.Repository.EmployeeRepository;
import main.main.Service.EmployeeService;
import main.main.Service.VehicleService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Secured("ROLE_USER")
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
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        model.addAttribute("vehiclesList", vehicleService.showOurCompanyVehicles(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject()));
        return "vehicle";
    }

    @GetMapping("/addVehicle")
    public String vehicle(Model model, HttpServletRequest request){
        KeycloakAuthenticationToken principal = (KeycloakAuthenticationToken) request.getUserPrincipal();
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("employeeList", employeeService.showEmployeesByUserId(principal.getAccount().getKeycloakSecurityContext().getIdToken().getSubject()));
        return "addVehicle";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute @Valid Vehicle vehicle, @ModelAttribute Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "addVehicle";
        }else{
            System.out.println(employee.getId()+ " ------------------");
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
