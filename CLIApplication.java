import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import com.example.cli.Command;
import com.example.cli.commands.*;

/**
 * A simple command line interface application using a command pattern.
 */
public class CLIApplication {
    
    private static final Map<String, Command> commands = new HashMap<>();
    
    static {
        // Initialize commands
        initializeCommands();
    }
    
    /**
     * Initialize all available commands.
     */
    private static void initializeCommands() {
        // Register basic commands
        registerCommand(new EchoCommand());
        registerCommand(new AddCommand());
        registerCommand(new MultiplyCommand());
        registerCommand(new TimeCommand());
        registerCommand(new FileCommand());
        registerCommand(new InfoCommand());
        
        // Register the batch command for executing scripts
        registerCommand(new BatchCommand(commands));
        
        // Register help command last so it can access all other commands
        registerCommand(new HelpCommand(commands));
    }
    
    /**
     * Register a command with the application.
     */
    private static void registerCommand(Command command) {
        commands.put(command.getName().toLowerCase(), command);
    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process command line arguments
            processCommands(args);
        } else {
            // Interactive mode
            runInteractiveMode();
        }
    }
    
    /**
     * Process commands passed as command line arguments.
     */
    private static void processCommands(String[] args) {
        String commandName = args[0].toLowerCase();
        String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);
        
        executeCommand(commandName, commandArgs);
    }
    
    /**
     * Run the application in interactive mode where user can enter commands.
     */
    private static void runInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the CLI Application!");
        System.out.println("Type 'help' for available commands or 'exit' to quit.");
        
        boolean running = true;
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                continue;
            }
            
            String[] parts = input.split("\\s+");
            String commandName = parts[0].toLowerCase();
            String[] commandArgs = Arrays.copyOfRange(parts, 1, parts.length);
            
            if (commandName.equals("exit") || commandName.equals("quit")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                executeCommand(commandName, commandArgs);
            }
        }
        
        scanner.close();
    }
    
    /**
     * Execute a command with the given arguments.
     */
    private static void executeCommand(String commandName, String[] args) {
        Command command = commands.get(commandName);
        
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + commandName);
            System.out.println("Type 'help' for available commands.");
        }
    }
}