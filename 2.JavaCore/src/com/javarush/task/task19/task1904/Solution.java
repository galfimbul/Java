package com.javarush.task.task19.task1904;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws Exception{
        PersonScannerAdapter test = new PersonScannerAdapter(new Scanner(new FileReader("D:\\test.txt")));
        System.out.println(test.read());

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }
        public Person read(){
            Person person = null;
            try {
                String line = fileScanner.nextLine();
                String[] partsOfString = line.split(" ");
                SimpleDateFormat ft = new SimpleDateFormat("dd MM yyyy");
                String data = partsOfString[3] + " " + partsOfString[4] + " " + partsOfString[5];
                Date birthday = ft.parse(data);


                 person = new Person(partsOfString[1], partsOfString[2], partsOfString[0],birthday);

            }
            catch (ParseException e){
                System.out.println("неправильный парсинг");
            }
            return person;
        }
        public void close(){fileScanner.close();}


    }
}
