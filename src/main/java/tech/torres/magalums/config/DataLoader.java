package tech.torres.magalums.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.torres.magalums.entity.Channel;
import tech.torres.magalums.entity.Status;
import tech.torres.magalums.repository.ChannelRepository;
import tech.torres.magalums.repository.StatusRepository;

import java.util.Arrays;
import java.util.Map;

@Configuration

    public class DataLoader implements CommandLineRunner {

        private final ChannelRepository channelRepository;
        private final StatusRepository statusRepository;

        public DataLoader(ChannelRepository channelRepository,
                          StatusRepository statusRepository){
            this.channelRepository = channelRepository;
            this.statusRepository  = statusRepository;

        }


        @Override
        public void run(String... args) throws Exception {
            Arrays.stream(Channel.Values.values())
                    .map(Channel.Values::toChannel)
                    .forEach(channelRepository::save);

            Arrays.stream(Status.Values.values())
                    .map(Status.Values::toStatus)
                    .forEach(statusRepository::save);


        }
    }

