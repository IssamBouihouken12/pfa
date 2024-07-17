package entity;
import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Setter
@Getter
@ToString
@Table(name="projets")
public class projet {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_proj;
    private String nom_proj;
    private float qte_mat;






}

