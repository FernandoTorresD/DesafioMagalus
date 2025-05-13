package tech.torres.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_channels")
public class Channel {

    @Id
    private Long channelid;

    private String description;

    public Channel(Long channelid, String description) {
        this.channelid = channelid;
        this.description = description;
    }

    public Channel() {
    }

    public Long getChannelid() {
        return channelid;
    }

    public void setChannelid(Long channelid) {
        this.channelid = channelid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),  // <- Corrigido
        WHATSAPP(4L, "whatsapp");

        private final Long id;
        private final String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(id, description);
        }
    }
}
