package main.main.Service;

import main.main.Model.Employee;
import main.main.Model.Transaction;
import main.main.Model.Vehicle;
import main.main.Repository.TransactionRepository;
import main.main.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final TransactionRepository transactionRepository;

    public VehicleService(VehicleRepository vehicleRepository, TransactionRepository transactionRepository) {
        this.vehicleRepository = vehicleRepository;
        this.transactionRepository = transactionRepository;
    }

    public void addVehicle(Vehicle vehicle, Employee employee){
        vehicle.setEmployee(employee);
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> showAllVehicles(){
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public List<Vehicle> showOurCompanyVehicles(String userId){
        return vehicleRepository.findAllByEmployeeUserId(userId);
    }

    public Optional<Vehicle> getOne(Long id){
        return vehicleRepository.findById(id);
    }

    public void updateVehicle(Vehicle vehicle){
        Optional<Vehicle> oldVehicle = this.getOne(vehicle.getId());
        oldVehicle.get().setVehicleType(vehicle.getVehicleType());
        oldVehicle.get().setBrand(vehicle.getBrand());
        oldVehicle.get().setCapacity(vehicle.getCapacity());
        oldVehicle.get().setRegisterNr(vehicle.getRegisterNr());
        oldVehicle.get().setReviewDate(vehicle.getReviewDate());
        oldVehicle.get().setInsuranceDate(vehicle.getInsuranceDate());
        vehicleRepository.save(oldVehicle.get());
    }

    public void deleteVehicle(Long id){
        List<Transaction> transactionList = transactionRepository.findAllByVehicle(getOne(id).get());
        for(Transaction transaction : transactionList){
            transaction.setVehicle(null);
            transaction.setVehicle(null); //to bedzie trzeba ladnie schowac
        }
        vehicleRepository.deleteById(id);
        transactionList.forEach(transactionRepository::save);
    }
}
