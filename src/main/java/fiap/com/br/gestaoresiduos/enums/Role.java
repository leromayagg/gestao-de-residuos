package fiap.com.br.gestaoresiduos.enums;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("admin"),
    USER("user");

    private String role;

    Role(String role) {this.role = role;}

}
