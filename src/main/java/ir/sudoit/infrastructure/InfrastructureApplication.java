package ir.sudoit.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InfrastructureApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(InfrastructureApplication.class, args);
    }

}
