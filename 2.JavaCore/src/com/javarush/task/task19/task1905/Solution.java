package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Contact contact = new Contact();

        DataAdapter adapter = new DataAdapter(customer,contact);
        System.out.println(adapter.getDialString());


    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String key = null;
            for(Map.Entry<String, String> pair:countries.entrySet()){
                if(pair.getValue().equals(customer.getCountryName()))
                key = pair.getKey();
            }
            return key;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(",");
            return name[1].substring(1);
        }

        @Override
        public String getContactLastName() {
            String[] lastName = contact.getName().split(",");
            return lastName[0];
        }

        @Override
        public String getDialString() {
            String number = contact.getPhoneNumber();
            number = number.replaceAll("[()+-]","");
            return "callto://+" + number;
        }
    }

    public  interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    /*public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }*/

    /*public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }*/
}