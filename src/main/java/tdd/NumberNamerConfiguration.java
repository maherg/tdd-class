package tdd;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class NumberNamerConfiguration {

    @Bean
    public NumberNameRepository repository() {
        return new EnglishNumberNameRepository();
    }

    @Bean
    public NumberNamer namer() {
        return new NumberNamer();
    }
}
