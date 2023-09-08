package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.repository.ReclamationRepository;
import java.util.Optional;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

@Service
@Slf4j
public class ReclamationService implements IReclamation {

    @Autowired
    ReclamationRepository rec;

    @Override
    public long addreclamation(reclamation e) {
        e.setStatus("en attente ...");
        rec.save(e);
        log.info("add event");
        return e.getIdReclamation();
    }

    @Override
    public Iterable<reclamation> getAllReclamation() {
        return rec.findAll();
    }

    public Optional<reclamation> findReclamationById(Long id) {
        return rec.findById(id);
    }


    @Override
    public void deleteReclamation(long id) {
        rec.deleteById(id);

    }





    @Override
    public Boolean update(reclamation e) {
        // Récupérez la réclamation existante par son ID
        Optional<reclamation> existingReclamation = rec.findById(e.getIdReclamation());

        if (existingReclamation.isPresent()) {
            reclamation updatedReclamation = existingReclamation.get();

            // Mettez à jour le statut
            updatedReclamation.setStatus("approuvée");

            // Enregistrez la réclamation mise à jour
            rec.save(updatedReclamation);

            return true;
        } else {
            // Gérez le cas où la réclamation n'a pas été trouvée par son ID
            return false;
        }
    }









    @Override
    public List<reclamation> searchReclamation(String keyword) {
        return rec.search(keyword);
    }

    @Override
    public List<reclamation> sortReclamations() {
        return rec.Trier();
    }

    @Override
    public void sendEmail(String recipientEmail, String subject, String body) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("springbootanulattest@gmail.com", "zlnpmlhsnfwsfzfo");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("amed14170@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("Failed to send email.", e);
        }
    }

}
