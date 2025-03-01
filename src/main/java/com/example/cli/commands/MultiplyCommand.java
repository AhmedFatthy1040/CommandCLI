package com.example.cli.commands;

import com.example.cli.BaseCommand;

/**
 * Command that multiplies a list of numbers together.
 */
public class MultiplyCommand extends BaseCommand {
    
    public MultiplyCommand() {
        super("multiply", "Multiply a list of numbers together");
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide numbers to multiply.");
            return;
        }
        
        try {
            double result = 1.0;
            for (String arg : args) {
                result *= Double.parseDouble(arg);
            }
            System.out.println("Product: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please provide valid numbers.");
        }
    }
    
    @Override
    public String getHelp() {
        return "multiply [num1] [num2] ... - Multiplies a list of numbers together and displays the product";
    }
}