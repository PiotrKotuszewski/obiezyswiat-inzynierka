package main.main.Repository;

import main.main.Model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails, Long> {
    EmployeeDetails getById(Long id);
}
