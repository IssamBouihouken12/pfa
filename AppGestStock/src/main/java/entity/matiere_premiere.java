package entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Table(name="matieres_premieres")
public class matiere_premiere {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_mat;
private double code_article;
private String libelle_article;
private String nom_fournisseur;
private float qte_mat;
private LocalDate   dp_mat;
private String unite_mesure;
private float prix_unitaire;
private double code_barre;
private String type_mat;





}
