package main.main;

import main.main.Model.*;
import main.main.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@SpringBootApplication
public class InzynierkaSpringBootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(InzynierkaSpringBootApplication.class, args);
    }
}