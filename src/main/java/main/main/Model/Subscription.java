package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private float prize;
    @Column(name = "start_date",nullable = false)
    private String startDate;
    @Column(name = "end_date", nullable = false)
    private String endDate;
    @Column(name = "user_id", nullable = false)
    private String userId;

    public Subscription(){}

    public Subscription(String name, float prize, String startDate, String endDate, String userId) {
        this.name = name;
        this.prize = prize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prize=" + prize +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
