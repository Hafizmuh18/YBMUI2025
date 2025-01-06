package formakara.web.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "email", nullable = true)
    private String email;

    @NotNull
    @Column(name = "no_hp", nullable = false)
    private String noHp;

    @Column(name = "password", nullable = true)
    private String password;

    @NotNull
    @Column(name = "asal_sekolah", nullable = false)
    private String asalSekolah;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tiket_to_id", referencedColumnName = "id", nullable = true)
    private TiketTo tiketTo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tiket_seminar_id", referencedColumnName = "id", nullable = true)
    private TiketSeminar tiketSeminar;
}
