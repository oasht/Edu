package org.example.reflection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyEntityTest {

    @Test
    void validationTest() throws ValidationException {
        MyEntity my=new MyEntity();
        Assertions.assertThrows(ValidationException.class,()->Validator.validate(my));
    }
}