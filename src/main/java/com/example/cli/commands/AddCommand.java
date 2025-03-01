package com.example.cli.commands;

import com.example.cli.BaseCommand;

/**
 * Command that adds a list of numbers together.
 */
public class AddCommand extends BaseCommand {
    
    public AddCommand() {
        super("add", "Add a list of numbers together");
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide numbers to add.");
            return;
        }
        
        try {
            double sum = 0;
            for (String arg : args) {
                sum += Double.parseDouble(arg);
            }
            System.out.println("Sum: " + sum);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid numbers.");
        }
    }
    
    @Override
    public String getHelp() {
        return "add [num1] [num2] ... - Adds a list of numbers together and displays the sum";
    }
}