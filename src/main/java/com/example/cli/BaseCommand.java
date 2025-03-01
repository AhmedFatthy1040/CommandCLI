package com.example.cli;

/**
 * Base class for all commands that provides common functionality.
 */
public abstract class BaseCommand implements Command {
    
    private final String name;
    private final String description;
    
    /**
     * Constructor for the base command.
     * 
     * @param name Command name
     * @param description Brief description of the command
     */
    public BaseCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public String getHelp() {
        return String.format("%s - %s", name, description);
    }
}