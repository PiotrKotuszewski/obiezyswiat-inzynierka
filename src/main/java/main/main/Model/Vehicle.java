package main.main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private Long id;
    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;
    @Column(name = "registration_number", nullable = false)
    private String registerNr;
    @Column(name = "vehicle_capacity", nullable = false)
    private float capacity;
    @Column(name = "review_date", nullable = false)
    private String reviewDate;
    @Column(name = "vehicle_brand", nullable = false)
    private String brand;
    @Column(name = "insurance_date", nullable = false)
    private String insuranceDate;

    @JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<Transaction> transactions;
    @OneToOne
    private Employee employee;

    public Vehicle(){}

    public Vehicle(VehicleType vehicleType, String registerNr, float capacity, String reviewDate, String brand, String insuranceDate) {
        this.vehicleType = String.valueOf(vehicleType);
        this.registerNr = registerNr;
        this.capacity = capacity;
        this.reviewDate = reviewDate;
        this.brand = brand;
        this.insuranceDate = insuranceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegisterNr() {
        return registerNr;
    }

    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", registerNr='" + registerNr + '\'' +
                ", capacity=" + capacity +
                ", reviewDate=" + reviewDate +
                ", brand='" + brand + '\'' +
                ", insuranceDate=" + insuranceDate +
                '}';
    }
}
