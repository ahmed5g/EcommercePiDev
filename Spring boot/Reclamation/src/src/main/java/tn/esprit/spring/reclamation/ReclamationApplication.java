package tn.esprit.spring.reclamation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"tn.esprit.spring.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.controller","tn.esprit.spring.services"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.repository"})
public class ReclamationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReclamationApplication.class, args);
    }

}
