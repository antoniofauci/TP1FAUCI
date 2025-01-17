package comptoirs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import comptoirs.entity.Commande;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    @Query(
            """
             SELECT SUM(l.quantite *l.produit.prixUnitaire* (1-l.commande.remise))
             FROM Ligne l
             WHERE l.commande.numero= :numeroCommande
             
            """ )
    BigDecimal montantArticles(Integer numeroCommande);
    @Query(
            """
             SELECT c.numero AS numeroCommande,
                    c.saisiele AS saisiele,
                    c.envoyeele AS envoyeele,
                    c.port AS port,
                    c.destinataire AS destinataire,
                    c.remise AS remise
             FROM Commande c
             WHERE c.client.code= :codeClient
             
            """ )
    List<Commande> findCommandeByCodeClient(String codeClient);

}