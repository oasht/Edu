package org.example.reflection.entityheirs;
import org.example.reflection.Entity;
import org.example.reflection.NeedToString;
import org.example.reflection.ToString;

@ToString(NeedToString.NO)
public class EntityWithYesAndNoFields extends Entity {
    @ToString(NeedToString.YES)
    private String field1 = "value1";
    @ToString(NeedToString.NO)
    private String field2 = "value2";
    private String field3 = "value3";
    private String field4 = "value4";
}
