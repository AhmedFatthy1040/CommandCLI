package com.example.cli.commands;

import com.example.cli.BaseCommand;

/**
 * Command that displays system information.
 */
public class InfoCommand extends BaseCommand {
    
    public InfoCommand() {
        super("info", "Show system information");
    }
    
    @Override
    public void execute(String[] args) {
        System.out.println("System Information:");
        System.out.println("  Java version: " + System.getProperty("java.version"));
        System.out.println("  OS name: " + System.getProperty("os.name"));
        System.out.println("  OS version: " + System.getProperty("os.version"));
        System.out.println("  User name: " + System.getProperty("user.name"));
        System.out.println("  User home: " + System.getProperty("user.home"));
        System.out.println("  Working directory: " + System.getProperty("user.dir"));
    }
    
    @Override
    public String getHelp() {
        return "info - Displays information about the system and environment";
    }
}