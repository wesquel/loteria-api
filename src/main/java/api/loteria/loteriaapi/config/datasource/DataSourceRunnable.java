package api.loteria.loteriaapi.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import api.loteria.loteriaapi.models.Bet;
import api.loteria.loteriaapi.repositories.BetRepository;

@Configuration
public class DataSourceRunnable implements CommandLineRunner {
    @Autowired
    private BetRepository betRepository;

    @Override
    public void run(String... args) throws Exception {

    }



}
