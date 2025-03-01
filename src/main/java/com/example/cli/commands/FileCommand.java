package com.example.cli.commands;

import com.example.cli.BaseCommand;
import java.io.File;

/**
 * Command that lists files in a directory.
 */
public class FileCommand extends BaseCommand {
    
    public FileCommand() {
        super("file", "List files in a directory");
    }
    
    @Override
    public void execute(String[] args) {
        String path = ".";
        if (args.length > 0) {
            path = args[0];
        }
        
        File directory = new File(path);
        if (!directory.exists()) {
            System.out.println("Error: Directory does not exist.");
            return;
        }
        
        if (!directory.isDirectory()) {
            System.out.println("Error: The provided path is not a directory.");
            return;
        }
        
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }
        
        System.out.println("Contents of directory: " + directory.getAbsolutePath());
        for (File file : files) {
            System.out.printf("%-20s %s%n", file.getName(), file.isDirectory() ? "<DIR>" : file.length() + " bytes");
        }
    }
    
    @Override
    public String getHelp() {
        return "file [path] - Lists files in the specified directory (or current directory if no path is provided)";
    }
}