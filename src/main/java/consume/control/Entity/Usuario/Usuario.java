package consume.control.Entity.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    private String nome;
    private String email;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ConsumoEnergetico> consumosEnergeticos;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ConsumoUsoDispositivo> consumoDispositivos;


    public Usuario(UsuarioRecordDTO dados) {
        nome = dados.nome();
        email = dados.email();
    }

    public long getId() {
        return id_usuario;
    }

    public void setId(long id) {
        this.id_usuario = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ConsumoEnergetico> getConsumosEnergeticos() { return consumosEnergeticos; }

    public List<ConsumoUsoDispositivo> getConsumoDispositivos() { return consumoDispositivos; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario == usuario.id_usuario && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, nome, email);
    }

}
