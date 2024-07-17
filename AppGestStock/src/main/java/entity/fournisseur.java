package entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Table(name="fournisseurs")
public class fournisseur {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_four;
    private String nom_four;
    private Long tel_four;
    private String adresse_four;


    public long getId() {
        return id_four;
    }

    public void setId(long id_four) {
        this.id_four = id_four;
    }

    @Column(name = "nom_four", nullable = false)
    public String getnom_four() {
        return nom_four;
    }

    public void nom_four(String nom_four) {
        this.nom_four = nom_four;
    }

    @Column(name = "tel_four", nullable = false)
    public Long gettel_four() {
        return tel_four;
    }

    public void settel_four(Long tel_four) {
        this.tel_four = tel_four;
    }

    @Column(name = "addresse_four", nullable = false)
    public String getadresse_four() {
        return adresse_four;
    }

    public void setadresse_four(String adresse_four) {
        this.adresse_four = adresse_four;
    }

    @Override
    public String toString() {
        return "Fournisseur [id=" + id_four + ", nom fournisseur=" + nom_four + ", telephone fournisseur=" + tel_four + ", adresse fournisseur=" + adresse_four + "]";

    }
}

