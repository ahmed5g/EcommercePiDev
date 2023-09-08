package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.reclamation;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
@Repository
public interface ReclamationRepository extends JpaRepository<reclamation, Long> {
    @Query(value = "SELECT * FROM reclamation e WHERE e.nom LIKE %:keyword% OR e.mail LIKE %:keyword%", nativeQuery = true)
    List<reclamation> search(@Param("keyword") String keyword);

    @Query(value = "select * from reclamation e ORDER BY e.nom DESC " ,nativeQuery = true)
    List<reclamation> Trier();
}
