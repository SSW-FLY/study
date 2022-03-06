package com.example.spock.utlis;

import com.example.spock.domain.Student;

import java.util.Hashtable;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author imp
 * @date 2022/2/28
 */
public class TestUtils {

    public static String SpockTest() {
        return "ok";
    }

    public static void main(String[] args) {
        TreeMap<Student, String> treeMap = new TreeMap<>();
        treeMap.put(new Student(), "1");
        treeMap.put(new Student(), "1");
        treeMap.put(new Student(), "1");
        treeMap.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
        Hashtable<String,String> hashtable = new Hashtable<>();

    }
}
