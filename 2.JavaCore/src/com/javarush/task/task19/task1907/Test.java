package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int a = Integer.parseInt(reader.readLine());
        //int b = Integer.parseInt(reader.readLine());
        //int c = Integer.parseInt(reader.readLine());
        //int[] mass = {a,b,c};
        int[] mass = {Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine())};
        Arrays.sort(mass);
        System.out.println(mass[1]);
    }
}
