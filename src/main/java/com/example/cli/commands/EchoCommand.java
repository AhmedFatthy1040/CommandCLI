package com.example.cli.commands;

import com.example.cli.BaseCommand;

/**
 * Command that echoes back the provided text.
 */
public class EchoCommand extends BaseCommand {
    
    public EchoCommand() {
        super("echo", "Display the provided text");
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println();
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
    @Override
    public String getHelp() {
        return "echo [text] - Displays the provided text back to the console";
    }
}