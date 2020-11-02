package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id;
    @Column(name = "company_name", nullable = false)
    private String companyName;
    @Column(name = "bid", nullable = false)
    private float bid;
    @Column(name = "route", nullable = false)
    private String route;
    @Column(name = "loading_place", nullable = false)
    private String loadingPlace;
    @Column(name = "unloading_place", nullable = false)
    private String unloadingPlace;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;

    public Transaction(){}

    public Transaction(String companyName, float bid, String route, String loadingPlace,
                       String unloadingPlace, String description) {
        this.companyName = companyName;
        this.bid = bid;
        this.route = route;
        this.loadingPlace = loadingPlace;
        this.unloadingPlace = unloadingPlace;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getLoadingPlace() {
        return loadingPlace;
    }

    public void setLoadingPlace(String loadingPlace) {
        this.loadingPlace = loadingPlace;
    }

    public String getUnloadingPlace() {
        return unloadingPlace;
    }

    public void setUnloadingPlace(String unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", bid=" + bid +
                ", route='" + route + '\'' +
                ", loadingPlace='" + loadingPlace + '\'' +
                ", unloadingPlace='" + unloadingPlace + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
