package com.company;

import org.newPackage.*;

public class Main {

    public static void main(String[] args) {
        Commands<Database> commands = new Commands<>();
        commands.commandLine(Database.initDatabase(), 0);
    }
}
