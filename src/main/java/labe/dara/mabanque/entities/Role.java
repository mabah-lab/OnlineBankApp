package labe.dara.mabanque.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor @ToString
@EqualsAndHashCode
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @Column(length = 20)
    private String role;


}
