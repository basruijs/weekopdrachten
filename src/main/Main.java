package main;

import main.exceptions.NumberUnderZeroException;
import main.service.PhoneService;

import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws NumberUnderZeroException {


        PhoneService phoneList = new PhoneService();
        Swing swing = new Swing(phoneList);



        //while (true) {
            swing.homeScreen();
//            Scanner scanner = new Scanner(System.in);
//            phoneList.printAllPhones();
//            System.out.println(phoneList.getSize()+1 + ": afsluiten");
//            System.out.println(phoneList.getSize()+2 + ": zoeken");
//            System.out.print("Geef een nummer: ");
//            int phoneNumber = 0;
//            try{
//                phoneNumber = scanner.nextInt();
//                scanner.nextLine();
//                for (int i = 0; i < 50; i++) {
//                    System.out.print("\n");
//                }
//
//
//                if (phoneNumber <= phoneList.getSize() && phoneNumber>0) {
//                    phoneList.getPhone(phoneNumber).printPhone();
//                    System.out.println("Druk op Enter om verder te gaan...");
//                    scanner.nextLine();
//                } else if (phoneNumber == phoneList.getSize()+1) {
//                    System.out.println("Systeem stopt");
//                    break;
//
//                } else if(phoneNumber==phoneList.getSize()+2){
//                    System.out.println("Voer uw zoekterm in: ");
//                    String searchword = scanner.nextLine();
//                    phoneList.searchPhones(searchword);
//                }
//
//                else {
//                    System.out.println("Dit is een te laag nummer.");
//                    System.out.println("Druk op enter om het nog eens te proberen.");
//                    scanner.nextLine();
//                    scanner.nextLine();
//                }
//            } catch (Exception e){
//                System.out.println("Verkeerde invoer. Probeer eens een van de nummers die hier boven staan.");
//                System.out.println("Druk op enter om het nog eens te proberen.");
//                scanner.nextLine();
//                scanner.nextLine();
//            }



        //}
    }



}


