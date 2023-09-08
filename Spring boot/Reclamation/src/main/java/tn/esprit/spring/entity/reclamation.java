package tn.esprit.spring.entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table( name ="reclamation")
public class reclamation implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idReclamation")
    private Long idReclamation; // Clé primaire

    private String mail;
    private String nom;
    private String message;

    private int telephone;

    private String status;

// Constructeur et accesseurs (getters) et mutateurs (setters)




}