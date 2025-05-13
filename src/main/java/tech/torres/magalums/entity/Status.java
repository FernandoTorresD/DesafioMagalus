package tech.torres.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long statusid;

    private String description;

    public Status() {
        }

    public Status(Long statusid, String description) {
        this.statusid = statusid;
        this.description = description;
    }

    public Long getStatusid() {
        return statusid;
    }

    public void setStatusid(Long statusid) {
        this.statusid = statusid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {

        PENDING(1L,"pending"),
        SUCCESS(2L,"success"),
        ERROR(3L, "error"),
        CANCELED(4L,"canceled");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }
        public Status toStatus() {
            return new Status(id, description);

        }
    }
}
