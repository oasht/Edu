package org.example.reflection;

import org.example.entities.Cat;
import org.junit.jupiter.api.Test;

class ObjectWriterTest {
    @Test
            void testWriterReader() {
//        Cat cat1 = new Cat("pushok");
//        Cat cat2 = new Cat("murka");
//        ObjectWriter<Cat>ow=new ObjectWriter<>("cats.txt");
//        ow.writeObjects(List.of(cat1,cat2));
        ObjectReader<Cat>reader=new ObjectReader<>("cats.txt");
        System.out.println(reader.readObjects());
    }
}