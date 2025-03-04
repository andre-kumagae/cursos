package academy.devdojo.springboot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// auto configuracao sem precisar criar propriedades
//@EnableAutoConfiguration
// escaneia os codigos da raiz
//@ComponentScan(basePackages = "academy.devdojo.springboot2")
// necessario para fins de seguranca
//@Configuration
// Todas estas anotacoes estao presentes na anotaca abaixo
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
