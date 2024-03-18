package org.example.postprocessors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.reflection.Default;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
@Default("defaultClass")
class TestObject2 {
    String name2;
    String name;
}

