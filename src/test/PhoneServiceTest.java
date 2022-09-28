package test;

import main.Phone;
import main.service.PhoneService;
import main.exceptions.NumberUnderZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneServiceTest {
    private PhoneService sut;

    @BeforeEach
    void setup() {
        sut = new PhoneService();
    }

    @Test
    void getSizeTest(){
        // Arrange

        // Act
        int testValue = sut.getSize();

        // Assert
        assertEquals(5, testValue);
    }

    @Test
    void getPhoneTest() throws NumberUnderZeroException {
        // Arrange


        // Act
        String testValue = sut.getPhone(1).getBrand();

        // Assert
        assertEquals("Huawei", testValue);
    }

    @Test
    void getPhoneListTest(){
        // Arrange
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
        ArrayList<Phone> phoneList = new ArrayList<Phone>();
        phoneList.add(huawei);
        phoneList.add(samsung);
        phoneList.add(apple);
        phoneList.add(google);
        phoneList.add(xiaomi);

        // Act
        ArrayList<Phone> testValue = sut.getAllPhones();

        // Assert
        for (int i = 0; i < sut.getSize(); i++) {
            assertEquals(phoneList.get(i).getBrand(), testValue.get(i).getBrand());
        }

    }

//    @Test
//    void getPhoneOrNullTest(){
//        // Arrange
//
//        // Act
//        Phone testValue = sut.getPhoneOrNull(-1);
//
//        // Assert
//        assertNull(testValue);
//    }

//    @Test
//    void searchCameraTest() throws NumberUnderZeroException {
//        // Arrange
//
//        // Act
//        int results = sut.searchPhones("camEra");
//
//        // Assert
//        assertEquals(results, 4);
//    }

//    @Test
//    public void searchCameraTest() throws NumberUnderZeroException {
//        int results;
//
//
//
//        results = sut.searchPhones("camera");
//
//
//
//        assertEquals(4, results);
//    }
//
//    @Test
//    void searchHuaweiTest() throws NumberUnderZeroException {
//        // Arrange
//
//        // Act
//        int results = sut.searchPhones("Huawei");
//
//        // Assert
//        assertEquals(results, 1);
//    }






}
