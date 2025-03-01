package com.example.cli;

/**
 * Interface for all CLI commands.
 */
public interface Command {
    
    /**
     * Execute the command with given arguments.
     * 
     * @param args Arguments for the command
     */
    void execute(String[] args);
    
    /**
     * Get the command name.
     * 
     * @return The name of the command
     */
    String getName();
    
    /**
     * Get the command description.
     * 
     * @return Description of what the command does
     */
    String getDescription();
    
    /**
     * Get help information for this command.
     * 
     * @return Detailed help information
     */
    String getHelp();
}