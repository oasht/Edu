package org.example.postprocessors;

import lombok.Getter;
import lombok.Setter;
import org.example.reflection.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component

class TestObject4 {
    @ToString
    String name="Test";
    @ToString
    int x=10;
}