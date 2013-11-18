package tdd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberNamerConfiguration {

    @Bean
    public NumberNameRepository repository() {
        return new PropertiesNumberNameRepositoryImpl();
    }

    @Bean
    public NumberNamer namer() {
        return new NumberNamer();
    }
}
