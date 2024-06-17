package viagens.web.api.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import viagens.web.api.until.UF;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder
@Table(name = "ENDERECO_PESSOA")
public class PessoaEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDENDERECO")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private UF uf;
    @Column(length = 50, nullable = false)
    private String cidade;
    @Column(length = 50)
    private String bairro;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ENDERECO_PESSOA", nullable = false, foreignKey = @ForeignKey(name = "FK_ENDERECO_PESSOA"))
    @JsonBackReference
    private Pessoa pessoa;

}
