package viagens.web.api.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder

public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDESTINO")
    private Long id;
    @Column(length = 50,nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String descricao;

    @OneToOne(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private DestinoEndereco destinoEndereco;

    @ManyToMany(mappedBy = "destino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reserva> reserva;

}
