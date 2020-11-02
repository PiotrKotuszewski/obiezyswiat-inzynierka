package main.main.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message")
    private Long id;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "data_send", nullable = false)
    private LocalDate sendDate;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    public Message(String text) {
        this.text = text;
        this.sendDate = LocalDate.now(); // Tak czy ma sam wpisywac?
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}
