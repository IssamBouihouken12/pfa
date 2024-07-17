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
@Table(name="users")
public class user {

        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Long id_user;
    private String nom_user;
    private String adresse_user;
    private Long tel_user;
    private String poste_user;
    private String departement_user;






}
