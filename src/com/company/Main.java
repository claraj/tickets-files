package com.company;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Main {

    static final String separator = ";";


    public static void main(String[] args) throws IOException {
	// write your code here

        LinkedList<Ticket> alltickets = new LinkedList<Ticket>();

        // Example ticket
        Ticket newTicket = new Ticket(5, "clara", "computer", new Date());
        alltickets.add(newTicket);

        // Read in more tickets
        BufferedReader reader = new BufferedReader(new FileReader("tickets.txt"));
        String line = reader.readLine();
        while (line != null) {

            Ticket ticket = turnLineIntoTicket(line);
            alltickets.add(ticket);
            line = reader.readLine();
        }

        reader.close();
        System.out.println(alltickets);

        // Write all tickets to new file
        BufferedWriter writer = new BufferedWriter(new FileWriter("openTicket.txt"));
        for (Ticket t : alltickets) {
            String writeToFile = t.stringForFile();
            writer.write(writeToFile);
            writer.newLine();
        }

        writer.close();

    }

    private static Ticket turnLineIntoTicket(String line) {

        String[] parts = line.split(separator);

        int id = Integer.parseInt(parts[0]);
        String reporter = parts[1];
        String issue= parts[2];

        long timestamp = Long.parseLong(parts[3]);
        Date reportedDate = new Date(timestamp);

        Ticket ticket = new Ticket(id, reporter, issue, reportedDate);

        return ticket;

    }
}
