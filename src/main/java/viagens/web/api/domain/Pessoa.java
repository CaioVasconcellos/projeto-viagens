package viagens.web.api.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import viagens.web.api.until.SEXO;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Builder

@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "unique_email"))
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPESSOA")
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    private SEXO sexo;
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private PessoaEndereco pessoaEndereco;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PessoaTelefone> pessoaTelefone;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Reserva> reserva;

}

