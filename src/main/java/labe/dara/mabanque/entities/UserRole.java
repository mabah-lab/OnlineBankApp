package labe.dara.mabanque.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table (name ="users_roles")
//@IdClass(UserRolesId.class)
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "username",foreignKey=@ForeignKey(name = "USER_ROLE_FK"))
    private User user;
    @ManyToOne
    @JoinColumn(name = "role",foreignKey=@ForeignKey(name = "ROLE_USER_FK"))
    private Role role;
}
