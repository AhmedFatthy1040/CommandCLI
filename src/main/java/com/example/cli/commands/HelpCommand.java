package com.example.cli.commands;

import com.example.cli.BaseCommand;
import com.example.cli.Command;
import java.util.Map;

/**
 * Command that displays help information about all available commands.
 */
public class HelpCommand extends BaseCommand {
    
    private final Map<String, Command> commands;
    
    /**
     * Create a new help command.
     * 
     * @param commands Map of all available commands
     */
    public HelpCommand(Map<String, Command> commands) {
        super("help", "Show help information");
        this.commands = commands;
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length > 0) {
            String commandName = args[0].toLowerCase();
            Command command = commands.get(commandName);
            if (command != null) {
                System.out.println(command.getHelp());
            } else {
                System.out.println("Unknown command: " + commandName);
            }
            return;
        }
        
        System.out.println("Available commands:");
        commands.values().forEach(cmd -> {
            System.out.printf("  %-15s - %s%n", cmd.getName(), cmd.getDescription());
        });
        System.out.println("\nType 'help [command]' for more information on a specific command.");
    }
    
    @Override
    public String getHelp() {
        return "help [command] - Display help information for all commands or specific command";
    }
}