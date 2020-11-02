package main.main.Service;

import main.main.Model.Employee;
import main.main.Model.EmployeeDetails;
import main.main.Model.Transaction;
import main.main.Model.Vehicle;
import main.main.Repository.EmployeeDetailsRepository;
import main.main.Repository.EmployeeRepository;
import main.main.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;
    private final TransactionRepository transactionRepository;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeDetailsRepository employeeDetailsRepository,
                           TransactionRepository transactionRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeDetailsRepository = employeeDetailsRepository;
        this.transactionRepository = transactionRepository;
    }

    public void addEmployee(Employee employee, EmployeeDetails employeeDetails){
        employee.setEmployeeDetails(employeeDetails);

        employeeDetailsRepository.save(employeeDetails);
        employeeRepository.save(employee);
    }

    public List<Employee> showAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> showEmployeesWithoutVehicle(){
        return employeeRepository.employees();
    }

    public List<Employee> showEmployeesByUserId(String userId){
        return employeeRepository.findAllByUserId(userId);
    }

    public void updateEmployee(Employee employee){
        Optional<Employee> oldEmployee = this.getOne(employee.getId());
        oldEmployee.get().setFirstName(employee.getFirstName());
        oldEmployee.get().setLastName(employee.getLastName());
        oldEmployee.get().setSalary(employee.getSalary());
        oldEmployee.get().setPosition(employee.getPosition());
        //Jak robilem employeeRepository.save(employee) bez tego wyzej to klucze obce jako null mi ustawialo
        //dlatego zroiblem tak "brzydko"
        employeeRepository.save(oldEmployee.get());
    }

    public void updateEmployeeVehicle(Long userId, Vehicle vehicle){
        Employee employee = employeeRepository.getOne(userId);
        employee.setVehicle(vehicle);
        employeeRepository.save(employee);
    }

    public Optional<Employee> getOne(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployeesByUserId(String userId){
        return employeeRepository.findAllByUserId(userId);
    }

    public void deleteEmployee(Long id){
        EmployeeDetails employeeDetails = employeeDetailsRepository.getById(this.getOne(id).get().getEmployeeDetails().getId());
        List<Transaction> transactionList = transactionRepository.findAllByEmployee(this.getOne(id).get());
        for(Transaction transaction : transactionList){
            transaction.setEmployee(null);
            transaction.setVehicle(null); //to bedzie trzeba ladnie schowac
        }
        employeeRepository.deleteById(id);
        employeeDetailsRepository.deleteById(employeeDetails.getId());
        transactionList.forEach(transactionRepository::save);
    }

}
