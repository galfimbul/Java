package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(console);
        result = result.replaceAll("\r\n", "");
        String[] mass = result.split(" ");
        if(mass[1].equals("+")){
            System.out.print( result + (Integer.parseInt(mass[0])+Integer.parseInt(mass[2])));
        }
        if(mass[1].equals("-")){
            System.out.print( result + (Integer.parseInt(mass[0]) - Integer.parseInt(mass[2])));
        }
        if(mass[1].equals("*")){
            System.out.print( result + (Integer.parseInt(mass[0]) * Integer.parseInt(mass[2])));
        }
        //System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

