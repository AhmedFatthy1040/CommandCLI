package com.example.cli.commands;

import com.example.cli.BaseCommand;
import com.example.cli.Command;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Command that executes commands from a batch file.
 */
public class BatchCommand extends BaseCommand {
    
    private final Map<String, Command> commands;
    
    public BatchCommand(Map<String, Command> commands) {
        super("batch", "Execute commands from a file");
        this.commands = commands;
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: Please provide a batch file path.");
            return;
        }
        
        String filePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            System.out.println("Executing commands from " + filePath);
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                
                // Skip empty lines and comments
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                
                System.out.println("[" + lineNumber + "] Executing: " + line);
                String[] parts = line.split("\\s+");
                String commandName = parts[0].toLowerCase();
                String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);
                
                Command command = commands.get(commandName);
                if (command != null) {
                    command.execute(commandArgs);
                } else {
                    System.out.println("Unknown command: " + commandName);
                }
            }
            System.out.println("Batch execution completed.");
            
        } catch (IOException e) {
            System.out.println("Error reading batch file: " + e.getMessage());
        }
    }
    
    @Override
    public String getHelp() {
        return "batch [file_path] - Executes commands from the specified file, one command per line";
    }
}