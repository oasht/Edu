package org.example.reflection.entityheirs;

import org.example.reflection.NeedToString;
import org.example.reflection.ToString;

@ToString(NeedToString.YES)
public class SubclassEntity extends EntityWithStaticFields {
    private String subField1 = "subValue1";
    private String subField2 = "subValue2";
}
