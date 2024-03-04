package org.example.reflection;

import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ObjectReader<T> {
    private String fileName;

    public ObjectReader(String fileName) {
        this.fileName = fileName;
    }

    @SneakyThrows
    public List<T>readObjects(){
        List<T>res=new ArrayList<>();
        Scanner sc=new Scanner(new File(fileName));
        while(sc.hasNext()){
            String[]objStr=sc.nextLine().split(" ");
            Class<T>clz=(Class<T>)Class.forName(objStr[0]);
            Constructor cstr=null;
            for(Constructor c:clz.getDeclaredConstructors()){
                if(c.getParameterCount()==objStr.length-1){
                    cstr=c;
                }
            }
            if(cstr==null)throw new ClassNotFoundException();
            cstr.setAccessible(true);
            res.add((T)cstr.newInstance((Arrays.copyOfRange(objStr,1,objStr.length))));
        }
        return res;
    }
}
