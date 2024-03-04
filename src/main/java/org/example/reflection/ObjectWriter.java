package org.example.reflection;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ObjectWriter <T>{
    private String fileName;
    public ObjectWriter(String fileName){
        this.fileName=fileName;
    }
    @SneakyThrows
    public void writeObjects(List<T>lst){
        File file=new File (fileName);
        FileWriter fw=new FileWriter(file);
        for(T obj:lst){
            fw.append(obj.toString());
            fw.append("\n");
        }
        fw.close();
    }
}
