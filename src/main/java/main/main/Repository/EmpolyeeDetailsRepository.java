package main.main.Repository;

import main.main.Model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpolyeeDetailsRepository extends CrudRepository<EmployeeDetails, Long> {
}
