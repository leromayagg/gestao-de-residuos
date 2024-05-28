package fiap.com.br.gestaoresiduos.model;

import fiap.com.br.gestaoresiduos.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_agendamento")
@Getter
@Setter
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AGENDAMENTO")
    @SequenceGenerator(name = "SEQ_AGENDAMENTO", sequenceName = "SEQ_AGENDAMENTO", allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;

    private Long timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
