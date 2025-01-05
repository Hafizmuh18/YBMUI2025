package formakara.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tiket_to")
public class TiketTo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = true)
    private String email;

    @NotNull
    @Column(name = "noHp", nullable = false)
    private String noHp;

    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "status", nullable = false)
    private String status;
}
