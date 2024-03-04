package org.example.reflection;

@Validate(TestForMyEntity.class)
public class MyEntity extends Entity{
    @ToString(NeedToString.YES)
    public int x=43;

    public String res="test";
}
