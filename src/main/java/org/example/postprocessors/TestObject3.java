package org.example.postprocessors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.reflection.Cache;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ToString
class TestObject3 implements TestInterface{
    @Cache
    public String test(){
        System.out.println("test is called");
        return "hello";
    }
}




