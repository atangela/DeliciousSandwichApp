package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(Order order) {
        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdir();
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        File receiptFile = new File(folder, timestamp + ".txt");

        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write(order.toString());
            System.out.println("Receipt saved: " + receiptFile.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error saving receipt: " + ex.getMessage());
        }
    }
}
