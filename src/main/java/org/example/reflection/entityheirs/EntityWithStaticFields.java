package org.example.reflection.entityheirs;
import org.example.reflection.Entity;
import org.example.reflection.NeedToString;
import org.example.reflection.ToString;

@ToString(NeedToString.YES)
public class EntityWithStaticFields extends Entity {
    private static String staticField1 = "staticValue1";
    private static String staticField2 = "staticValue2";
    private String field1 = "value1";
}
