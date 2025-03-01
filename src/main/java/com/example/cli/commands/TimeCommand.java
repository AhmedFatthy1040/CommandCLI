package com.example.cli.commands;

import com.example.cli.BaseCommand;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Command that displays the current date and time.
 */
public class TimeCommand extends BaseCommand {
    
    public TimeCommand() {
        super("time", "Display the current date and time");
    }
    
    @Override
    public void execute(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Current date and time: " + formatter.format(date));
    }
    
    @Override
    public String getHelp() {
        return "time - Displays the current date and time in yyyy-MM-dd HH:mm:ss format";
    }
}