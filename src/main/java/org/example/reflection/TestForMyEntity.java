package org.example.reflection;

public class TestForMyEntity {
    void test1(MyEntity myEntity) throws ValidationException {
        if(myEntity.x!=42) {
            throw new ValidationException("must be 42");
        }
    }

    void test2(MyEntity myEntity) throws ValidationException{
        if(myEntity.res==null) throw new ValidationException("must be not null");
    }
}
