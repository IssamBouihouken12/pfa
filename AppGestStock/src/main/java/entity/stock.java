package entity;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name="stocks")
public class stock {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_stock;
    private Long id_mat;
    private float qte_mat;



}
