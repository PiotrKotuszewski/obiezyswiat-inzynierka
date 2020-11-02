package main.main.Repository;

import main.main.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary);
    List<Employee> findAllByUserId(String userId);
    Employee getByUserId(String userId);

    Optional<Employee> findById(Long id);
}
