package viagens.web.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import viagens.web.api.until.TipoTelefone;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder

@Table(name = "TELEFONE_PESSOA")
public class PessoaTelefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTELEFONE")
    private Long id;
    @Column(length = 50, nullable = false)
    private String numero;
    @Enumerated(EnumType.STRING)
    @Column(length = 3, nullable = false)
    private TipoTelefone tipoTelefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_TELEFONE_PESSOA", nullable = false, foreignKey = @ForeignKey(name = "FK_TELEFONE_PESSOA"))
    @JsonBackReference
    private Pessoa pessoa;

}
