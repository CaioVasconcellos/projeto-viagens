package viagens.web.api.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import viagens.web.api.until.TipoReservas;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder

@Table(uniqueConstraints = @UniqueConstraint(columnNames = "dataMarcada", name = "unique_dataMarcada"))
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRESERVA")
    private Long id;
    @Column(nullable = false,unique = true)
    private LocalDate dataMarcada;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoReservas tipoReservas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "RESERVA_DESTINO",
            joinColumns = @JoinColumn(name = "FK_RESERVA_DESTINO"),
            inverseJoinColumns = @JoinColumn(name = "IDDESTINO"),
            foreignKey = @ForeignKey(name = "FK_RESERVA_DESTINO"),
            inverseForeignKey = @ForeignKey(name = "FK_DESTINO_RESERVA")
    )
    @JsonBackReference
    private List<Destino> destino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_RESERVA_PESSOA", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVA_PESSOA"))
    @JsonBackReference
    private Pessoa pessoa;


}
