package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        IncomeData ic = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "RU";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 7;
            }

            @Override
            public int getPhoneNumber() {
                return 501234567;
            }
        };

        IncomeDataAdapter icd = new IncomeDataAdapter(ic);
        Customer customer = icd;
        Contact contact = icd;

        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());

        System.out.println();

        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }
        public String getCompanyName(){
            return data.getCompany();
        }

        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        public String getName() {
            return data.getContactLastName()+ ", " + data.getContactFirstName();
        }

        public String getPhoneNumber(){
            int number = data.getPhoneNumber();
            StringBuilder phone = new StringBuilder();
            phone.append(number);
            if(phone.length()<10){
                while(phone.length()<10){
                    phone.insert(0,"0");
                }
            }
            phone.insert(0,"(");
            phone.insert(4,")");
            phone.insert(8,"-");
            phone.insert(11,"-");

            return "+" + data.getCountryPhoneCode()  + phone.toString();
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}