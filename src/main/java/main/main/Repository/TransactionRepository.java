package main.main.Repository;

import main.main.Model.Employee;
import main.main.Model.Transaction;
import main.main.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> getAllByEmployeeIsNull();
    List<Transaction> getAllByEmployeeIsNotNull();
    List<Transaction> findAllByEmployee(Employee employee);
    List<Transaction> findAllByVehicle(Vehicle vehicle);
    List<Transaction> findAllByEmployeeUserId(String userId);
    Optional<Transaction> findById(Long id);
}
