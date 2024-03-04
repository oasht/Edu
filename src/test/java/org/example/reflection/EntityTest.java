package org.example.reflection;

import org.example.reflection.entityheirs.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class EntityTest {
    @Test
    void testToString(){

        MyEntity my=new MyEntity();
        System.out.println(my);

    }

    @Test
    void testAllFieldsWithAnnotationYes() {

        Entity entity = new EntityWithAllFieldsYesAnnotation();

        String result = entity.toString();

        assertTrue(result.contains("field1=value1"));
        assertTrue(result.contains("field2=value2"));
        assertTrue(result.contains("field3=value3"));
        assertTrue(result.contains("field4=value4"));
    }
    @Test
    void testSomeFieldsWithAnnotationsYesAndNo() {

        Entity entity = new EntityWithYesAndNoFields();

        String result = entity.toString();

        assertTrue(result.contains("field1"));
        assertFalse(result.contains("field2"));
        assertFalse(result.contains("field3=value3"));
        assertFalse(result.contains("field4=value4"));
    }

    @Test
    void testAllFieldsWithAnnotationNo() {
        Entity entity = new EntityWithAllFieldsNoAnnotation();
        String result = entity.toString();

        assertFalse(result.contains("field1"));
        assertFalse(result.contains("field2"));
        assertFalse(result.contains("field3"));
        assertFalse(result.contains("field4"));
    }

    @Test
    void testStaticFields() {
        Entity entity = new EntityWithStaticFields();
        String result = entity.toString();

        assertTrue(result.contains("field1=value1"));
        assertFalse(result.contains("staticField1"));
        assertFalse(result.contains("staticField2"));
    }

    @Test
    void testSubclassFields() {
        Entity subclassEntity = new SubclassEntity();
        String result = subclassEntity.toString();

        assertTrue(result.contains("subField1=subValue1"));
        assertTrue(result.contains("subField2"));
        assertFalse(result.contains("staticValue1"));
        assertFalse(result.contains("staticValue2"));
        assertTrue(result.contains("value1"));
    }

    @Test
    void testToString_NoAnnotation() {
        EntityWithoutAnnotation entity = new EntityWithoutAnnotation();
        String result = entity.toString();
        assertEquals("EntityWithoutAnnotation{field1=value1}", result);
    }

    @Test
    void testToString_NoFields() {
        EntityWithNoFields entity = new EntityWithNoFields();
        String result = entity.toString();
        assertEquals("EntityWithNoFields{}", result);
    }
}