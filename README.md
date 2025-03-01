# CommandCLI

A modular and extensible Command Line Interface application built in Java using the command design pattern.

## Features

- **Modular Design** - Easy to add new commands without modifying existing code
- **Interactive Mode** - Enter commands in an interactive shell environment
- **Batch Processing** - Run commands from script files
- **Built-in Commands**:
  - `help` - Display available commands and detailed help information
  - `add` - Sum a list of numbers
  - `multiply` - Multiply a list of numbers
  - `echo` - Display text
  - `time` - Show current date and time
  - `file` - List files in a directory
  - `info` - Show system information
  - `batch` - Execute commands from a file

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Compilation

```bash
javac -d . CLIApplication.java src/main/java/com/example/cli/*.java src/main/java/com/example/cli/commands/*.java
```

### Running the Application

#### Interactive Mode

```bash
java CLIApplication
```

This will start the application in interactive mode where you can type commands directly.

#### Command Line Mode

```bash
java CLIApplication <command> [arguments]
```

Example:
```bash
java CLIApplication add 5 10 15
```

## Usage Examples

### Add Command
```
> add 5 10 15 20
Sum: 50
```

### Multiply Command
```
> multiply 2 3 4
Product: 24
```

### Echo Command
```
> echo Hello World
Hello World
```

### Time Command
```
> time
Current date and time: 2023-07-15 14:30:45
```

### Help Command
```
> help
Available commands:
  add             - Add a list of numbers together
  help            - Show help information
  file            - List files in a directory
  batch           - Execute commands from a file
  echo            - Display the provided text
  time            - Display the current date and time
  multiply        - Multiply a list of numbers together
  info            - Show system information

Type 'help [command]' for more information on a specific command.
```

### Batch Command
Create a file `commands.txt` with commands:
```
echo Starting batch execution
add 10 20 30
time
echo Finished batch execution
```

Then run:
```
> batch commands.txt
```

## Project Structure

```
.
├── CLIApplication.java        # Main application class
└── src/main/java/com/example/cli/
    ├── Command.java           # Command interface
    ├── BaseCommand.java       # Abstract base implementation of Command
    └── commands/              # Individual command implementations
        ├── AddCommand.java
        ├── BatchCommand.java
        ├── EchoCommand.java
        └── ...
```

## Screenshot
![Screenshot 2025-03-01 173510](https://github.com/user-attachments/assets/e3dfcb1a-0372-48d4-b40f-90d1de3cb379)


## Extending with New Commands

1. Create a new class that extends `BaseCommand` or implements the `Command` interface
2. Implement the required methods
3. Register your command in `CLIApplication.java`'s `initializeCommands()` method

Example:
```java
// Create a new command class
public class MyCommand extends BaseCommand {
    public MyCommand() {
        super("mycommand", "Description of my command");
    }
    
    @Override
    public void execute(String[] args) {
        // Implementation
    }
    
    @Override
    public String getHelp() {
        return "mycommand [args] - Detailed help information";
    }
}

// Register in CLIApplication.java
private static void initializeCommands() {
    // Other commands...
    registerCommand(new MyCommand());
}
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.
