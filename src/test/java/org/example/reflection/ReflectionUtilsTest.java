package org.example.reflection;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.reflection.ReflectionUtils.reset;

class ReflectionUtilsTest {

    @NoArgsConstructor
    static class A {
        @Invoke String a() {return "a";}
        @Invoke static String b() {return "b";}
    }

    @NoArgsConstructor
    static class B {
        @Invoke String a() {return "a";}
        @Invoke String b() {return "b";}
        @Invoke String c(String g) {return "c";}
        String d() {return "d";}
    }

    @Test
    void testCollect() {
        System.out.println(ReflectionUtils.collect(List.of(A.class, B.class)));
    }

    @ToString
    @Default
    static class C{
        int c = 3;
        double d = 131;
        String s = "a";
    }

    @Test
    void testReset(){
        C c = new C();
        C c1 = new C();
        reset(List.of(c, c1));
        System.out.println(c);
        System.out.println(c1);
    }

}