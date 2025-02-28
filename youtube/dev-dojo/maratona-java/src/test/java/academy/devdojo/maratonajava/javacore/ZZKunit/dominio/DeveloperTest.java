package academy.devdojo.maratonajava.javacore.ZZKunit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperTest {

    @Test
    public void instanceOf_ExecutesChildClassMethod_WhenObjectIsOdChildType() {
        Employee employeeDeveloper = new Developer("1", "Java");
//        forma antiga
//        if (employeeDeveloper instanceof Developer) {
//            Developer developer = (Developer) employeeDeveloper;

//        forma nova resumindo o casting no if
        if (employeeDeveloper instanceof Developer developer) {
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}