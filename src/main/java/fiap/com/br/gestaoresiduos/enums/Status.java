package fiap.com.br.gestaoresiduos.enums;

import lombok.Getter;

@Getter
public enum Status {
    CONFIRMADO("confirmado"),
    PENDENTE("pendente");

    private String status;


    Status(String status) {
        this.status = status;
    }
}
