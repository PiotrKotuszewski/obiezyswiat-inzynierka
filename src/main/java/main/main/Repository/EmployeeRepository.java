package main.main.Repository;

import main.main.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllBySalary(float salary);
    List<Employee> findAllByUserId(String userId);
    Employee getByUserId(String userId);
    @Query("SELECT a FROM Employee a where a.id not in (select b.employee from Vehicle b)")
    List<Employee> employees();


    Optional<Employee> findById(Long id);
}
