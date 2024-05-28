package fiap.com.br.gestaoresiduos.model;

import fiap.com.br.gestaoresiduos.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_usuario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIOS"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIOS", sequenceName = "SEQ_USUARIOS", allocationSize = 1
    )
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ADMIN"),
                    new SimpleGrantedAuthority("USER"));
        }
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
