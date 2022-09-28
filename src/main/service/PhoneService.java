package main.service;

import main.Phone;
import main.exceptions.NumberUnderZeroException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class PhoneService {
    Phone huawei = new Phone(1, "Huawei", "P30", new BigDecimal(697), "6.47\" FHD+ (2340x1080) OLED, Kirin 980 Octa-Core (2x Cortex-A76 2.6GHz\n" +
            "+ 2x Cortex-A76 1.92GHz + 4x Cortex-A55 1.8GHz), 8GB RAM, 128GB ROM,\n" +
            "40+20+8+TOF/32MP, Dual SIM, 4200mAh, Android 9.0 + EMUI 9.1", 12);
    Phone samsung = new Phone(2, "Samsung", "Galaxy A52", new BigDecimal(399), "64 megapixel camera, 4k videokwaliteit 6.5 inch AMOLED scherm 128 GB\n" +
            "opslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig\n" +
            "(IP67)\n", 14);
    Phone apple = new Phone(3, "Apple", "IPhone 11", new BigDecimal(619), "Met de dubbele camera schiet je in elke situatie een perfecte foto of video\n" +
            "De krachtige A13-chipset zorgt voor razendsnelle prestaties Met Face ID\n" +
            "hoef je enkel en alleen naar je toestel te kijken om te ontgrendelen Het\n" +
            "toestel heeft een lange accuduur dankzij een energiezuinige processor\n", 21);
    Phone google = new Phone(4, "Google", "Pixel 4a", new BigDecimal(411), "12.2 megapixel camera, 4k videokwaliteit 5.81 inch OLED scherm 128 GB\n" +
            "opslaggeheugen 3140 mAh accucapaciteit\n", 4);
    Phone xiaomi = new Phone(5, "Xiaomi", "Redmi note 10 pro", new BigDecimal(298), "108 megapixel camera, 4k videokwaliteit 6.67 inch AMOLED scherm 128\n" +
            "GB opslaggeheugen (Uitbreidbaar met Micro-sd) Water- en stofbestendig\n" +
            "(IP53)", 1);
    ArrayList<Phone> phoneList = new ArrayList<Phone>(

    );

    public PhoneService() {
        phoneList.add(huawei);
        phoneList.add(samsung);
        phoneList.add(apple);
        phoneList.add(google);
        phoneList.add(xiaomi);
    }


    public int getSize() {
        return phoneList.size();
    }

    public ArrayList<Phone> searchPhones(String keyword) throws NumberUnderZeroException {
        int numberOfResults = 0;
        boolean keepSearching = true;
        //TODO: methodes maken voor de tolowercase gedoeën
        //while (keepSearching) {
        //            for (Phone value : searchedList) {
//                numberOfResults++;
//                value.printBrand();
//            }
//            System.out.println("Druk op een van de bovenstaande nummers om die telefoon te bekijken. " +
//                    "Druk op een ander nummer om terug te gaan naar het hoofdmenu.");
//            Scanner scanner = new Scanner(in);
//            String input = scanner.nextLine();
//            int number = Integer.parseInt(input);
//            keepSearching = false;
//            for (Phone phone : searchedList) {
//
//                if (phone.getPropertyId() == number) {
//                    keepSearching = true;
//                    getPhone(number).printPhone();
//                }
//            }
//            scanner.nextLine();
//        }


        return (ArrayList<Phone>) phoneList.stream().
                filter(e -> e.getBrand().toLowerCase().contains(keyword.toLowerCase())
                        || e.getDescription().toLowerCase().contains(keyword.toLowerCase())
                        || e.getType().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

    }

//    public int searchPhones(String keyword) throws NumberUnderZeroException {
//        int numberOfResults = 0;
//        boolean keepSearching = true;
//        //TODO: methodes maken voor de tolowercase gedoeën
//        while (keepSearching) {
//            ArrayList<Phone> searchedList = (ArrayList<Phone>) phoneList.stream().
//                    filter(e -> e.getBrand().toLowerCase().contains(keyword.toLowerCase())
//                            || e.getDescription().toLowerCase().contains(keyword.toLowerCase())
//                            || e.getType().toLowerCase().contains(keyword.toLowerCase()))
//                    .collect(Collectors.toList());
//            for (Phone value : searchedList) {
//                numberOfResults++;
//                value.printBrand();
//            }
////            System.out.println("Druk op een van de bovenstaande nummers om die telefoon te bekijken. " +
////                    "Druk op een ander nummer om terug te gaan naar het hoofdmenu.");
//            Scanner scanner = new Scanner(in);
//            String input = scanner.nextLine();
//            int number = Integer.parseInt(input);
//            keepSearching = false;
//            for (Phone phone : searchedList) {
//
//                if (phone.getPropertyId() == number) {
//                    keepSearching = true;
//                    getPhone(number).printPhone();
//                }
//            }
//            scanner.nextLine();
//        }
//
//        return numberOfResults;
//
//    }

    public Phone getPhone(int phone) throws NumberUnderZeroException {
        try {
            return phoneList.stream().filter(e -> e.getPropertyId() == phone).findFirst().orElseThrow();
        } catch (Exception e) {
            throw new NumberUnderZeroException("Het nummer is te laag");
        }
    }

    public Phone getPhoneOrNull(int phone) {
        try {
            return phoneList.get(phone);
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Phone> getAllPhones() {
        return phoneList;
    }

    public void printAllPhones() {
        for (Phone phone : phoneList) {
            phone.printBrand();
        }
    }

    public String searchResults(){
        StringBuilder result = new StringBuilder();
        for (Phone phone : phoneList) {
            result.append(phone.shortPhone());
            result.append("\n");
        }
        return String.valueOf(result);
    }

}
