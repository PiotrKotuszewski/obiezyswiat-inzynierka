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
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailsRepository employeeDetailsRepository;

    public TransactionService(TransactionRepository transactionRepository, EmployeeRepository employeeRepository,
                              EmployeeDetailsRepository employeeDetailsRepository) {
        this.transactionRepository = transactionRepository;
        this.employeeRepository = employeeRepository;
        this.employeeDetailsRepository = employeeDetailsRepository;
    }

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public List<Transaction> showAvailableTransactions(){
        return transactionRepository.getAllByEmployeeIsNull();
    }

    public List<Transaction> showAssignedTransactions(String userId){
        return transactionRepository.findAllByEmployeeUserId(userId);
    }

    public Optional<Transaction> getOne(Long id){
        return transactionRepository.findById(id);
    }

    public void assign(Transaction transaction, Long id){
        Employee employee = employeeRepository.findById(id).get();
        if(!employee.getTransactions().contains(transaction)){
            transaction.setEmployee(employee);

            List<Transaction> transactions = employee.getTransactions();
            transactions.add(transaction);
            employee.setTransactions(transactions);

            EmployeeDetails employeeDetails = employeeDetailsRepository.getById(employee.getEmployeeDetails().getId());
            employeeDetails.setSumCostTrans(employeeDetails.getSumCostTrans() + transaction.getBid());
            employeeDetails.setTransactionsCount(employeeDetails.getTransactionsCount()+1);

            employeeDetailsRepository.save(employeeDetails);
            employeeRepository.save(employee);
            transactionRepository.save(transaction);
        }
    }
}
