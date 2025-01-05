package formakara.web.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders") // Renamed to avoid conflict with SQL reserved keyword "order"
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "jenis_order", nullable = false)
    private String jenisOrder;

    @Column(name = "offline_order", nullable = true)
    private boolean offlineOrder;

    @NotNull
    @Column(name = "status_pembayaran", nullable = false)
    private String statusPembayaran;

    @NotNull
    @Column(name = "nominal", nullable = false)
    private String nominal;

    @ManyToOne
    @JoinColumn(name = "buyer1_id", referencedColumnName = "id", nullable = false)
    private Buyer buyer1;

    @ManyToOne
    @JoinColumn(name = "buyer2_id", referencedColumnName = "id", nullable = true)
    private Buyer buyer2;

    @NotNull
    @Column(name = "bukti", nullable = false, columnDefinition = "BYTEA")
    private byte[] bukti;
}