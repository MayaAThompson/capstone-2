package com.pluralsight;

import com.pluralsight.items.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {

    static LocalDateTime dateTime;
    int orderNumber;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    private static final String savePath = "./src/main/resources/receipts/";

    public static void saveReceipt(Order o) {
        List<Item> items = o.getOrder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(savePath + dateTime.format(formatter) + ".txt"));
            for (Item item : items) {
                writer.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
