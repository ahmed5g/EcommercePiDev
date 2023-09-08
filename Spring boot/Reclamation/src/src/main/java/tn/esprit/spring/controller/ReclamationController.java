package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.spring.services.IReclamation;
import tn.esprit.spring.services.EmailService;
import tn.esprit.spring.entity.reclamation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ReclamationC")
public class ReclamationController {

    @Autowired
    IReclamation reclamtionservice;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender javaMailSender;

    //http://localhost:8088/ReclamationC/add-reclamation
    @PostMapping("/add-reclamation")
    @ResponseBody /* serialisation de l’objet en json*/
    public void addReclamation(@RequestBody reclamation d) throws MessagingException {
        reclamtionservice.addreclamation(d);
        String recipientEmail = d.getMail();
        String nom = d.getNom();
        String messageContent = "Votre réclamation a été enregistrée avec succès. Nous la traiterons dans les plus brefs délais.";
        reclamtionservice.sendEmail(recipientEmail,nom ,messageContent);
    }

    //api de recuperation de tous les reclamations
    // http://localhost:8088/ReclamationC/reclamations
    @GetMapping("/reclamations")
    @ResponseBody
    public Iterable<reclamation> getAllDepartements() {
        return reclamtionservice.getAllReclamation();
    }

    // api de recuperation des reclamations par id
    // http://localhost:8088/ReclamationC/reclamations/2
    @GetMapping("/reclamations/{id}")
    @ResponseBody
    public Optional<reclamation> getDepartementById(@PathVariable long id) {
        return reclamtionservice.findReclamationById(id);
    }

    // api suppression reclamations
    // http://localhost:8088/ReclamationC/deleteReclamati   on/1
    @DeleteMapping("/deleteReclamation/{id}")
    @ResponseBody
    public void supprimerDepartement(@PathVariable("id") long id) {
        reclamtionservice.deleteReclamation(id);
    }

    // api de modification reclamations
    // http://localhost:8088/ReclamationC/updateReclamation
    @PutMapping("/updateReclamation")
    @ResponseBody
    public void update(@RequestBody reclamation reclamations) throws MessagingException {
        reclamtionservice.update(reclamations);
        String recipientEmail = reclamations.getMail();
        String nom = reclamations.getNom();
        String messageContent = "Votre réclamation a été approuvée avec succès.";
        reclamtionservice.sendEmail(recipientEmail,nom ,messageContent);
    }

    // API de recherche de réclamations par mot-clé
    // http://localhost:8088/ReclamationC/searchReclamations?keyword=motcle
    @GetMapping("/searchReclamations")
    @ResponseBody
    public Iterable<reclamation> searchReclamations(@RequestParam("keyword") String keyword) {
        return reclamtionservice.searchReclamation(keyword);
    }

    // API de tri des réclamations par champ
    // http://localhost:8088/ReclamationC/sortReclamations
    @GetMapping("/sortReclamations")
    @ResponseBody
    public Iterable<reclamation> sortReclamations() {
        return reclamtionservice.sortReclamations();
    }

    private void sendEmail(String recipientEmail, String contenuMessage) {
        String sujet = "Notification de réclamation";
        emailService.sendSimpleEmail(recipientEmail, sujet, contenuMessage);

    }

    @GetMapping("/search")
    public List<reclamation> searchReclamation(@RequestParam("keyword") String keyword) {
        List<reclamation> reclamations = reclamtionservice.searchReclamation(keyword);
        return reclamations;
    }


}
