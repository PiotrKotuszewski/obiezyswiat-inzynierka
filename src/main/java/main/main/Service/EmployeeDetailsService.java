package main.main.Service;

import main.main.Repository.EmployeeDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {

    private final EmployeeDetailsRepository employeeDetailsRepository;

    public EmployeeDetailsService(EmployeeDetailsRepository employeeDetailsRepository) {
        this.employeeDetailsRepository = employeeDetailsRepository;
    }
}
