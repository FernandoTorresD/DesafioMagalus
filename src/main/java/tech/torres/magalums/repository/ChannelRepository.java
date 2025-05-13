package tech.torres.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.torres.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
