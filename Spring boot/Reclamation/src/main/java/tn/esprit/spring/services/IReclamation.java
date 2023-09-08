package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.reclamation;

import javax.mail.MessagingException;

public interface IReclamation {

    public long addreclamation(reclamation e);
    public Iterable<reclamation> getAllReclamation() ;
    Optional< reclamation > findReclamationById(Long id);
    public  void deleteReclamation(long id);
    public Boolean update(reclamation e);

    public List<reclamation> searchReclamation(String keyword) ;

    List<reclamation> sortReclamations();


    void sendEmail(String recipientEmail, String subject, String body) throws MessagingException;
}
