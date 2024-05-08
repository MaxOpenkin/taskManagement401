package org.taskmanagement401.service.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInput {
    public static String inputText(String text){
        System.out.println(text);
        Scanner ns=new Scanner(System.in);
        return ns.nextLine();
    }

    public static int inputPositiveInt(String text){
        System.out.println(text);
        Scanner ns=new Scanner(System.in);
        String str=ns.nextLine();
        if(checkDigit(str)){
            int res= Integer.parseInt(str);
            if(res>0){
                return res;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    public static boolean inputBool(String text){
        System.out.println(text+" (y/n)");
        Scanner ns=new Scanner(System.in);
        return ns.nextLine().equalsIgnoreCase("y");
 }
   private static boolean checkDigit(String str){
        boolean test=true;
        if(str.isEmpty()){
            return false;
        }else {
            for (int i = 0; i < str.length() && test; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    test = false;
                }
            }
        }
        return test;
    }

    public static int inputInteger(String text) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(text);
        int inputInteger = scanner.nextInt();
        return inputInteger;
    }
    public static LocalDate inputDate(String dateString) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(dateString);
        DateTimeFormatter[] dateFormatters = {
                DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ofPattern("dd.MM.yy")
        };

        LocalDate date = null;

        while (date == null) {
            String sTime = scanner.nextLine();
            for (DateTimeFormatter dateFormatter : dateFormatters) {
                try {
                    date = LocalDate.parse(sTime, dateFormatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println();
                }
            }
        }

        return date;
    }
}
