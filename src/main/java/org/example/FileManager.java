package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(Order order) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timestamp + ".txt";

        try {
            java.nio.file.Files.createDirectories(java.nio.file.Path.of("receipts"));
            FileWriter writer = new FileWriter(fileName);
            writer.write(order.toString());
            writer.close();
            System.out.println("Receipt saved as " + fileName);
        } catch (IOException ex) {
            System.out.println("Error saving receipt: " + ex.getMessage());
        }
    }
}
