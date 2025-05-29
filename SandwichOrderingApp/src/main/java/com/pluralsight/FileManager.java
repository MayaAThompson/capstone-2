package com.pluralsight;

import com.pluralsight.items.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileManager {

    private static final String SAVE_PATH = "./src/main/resources/receipts/";
    private static final LocalDateTime DATE_TIME = LocalDateTime.now();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

    @SuppressWarnings("all")
    public static void saveReceipt(Order o) {
        List<Item> items = o.getOrder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_PATH + DATE_TIME.format(FORMATTER) + ".txt"))) {
            for (Item item : items) {
                writer.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
