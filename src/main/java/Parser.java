public class Parser {
    public static Command parse(String command) throws DukeException {
            String[] commandArray = command.split(" ");
            switch (commandArray[0].toUpperCase()) {
                case "TODO": {
                    if (commandArray.length == 1) {
                        throw new DukeException("You have to tell me what you want to do >.<");
                    }
                    String taskDetails = commandArray[1].strip();
                    return new TodoCommand(taskDetails);
                }
                case "LIST": {
                    return new ListCommand();
                }
                case "MARK": {
                    String taskNum = commandArray[1].strip();
                    return new MarkCommand(taskNum);
                }
                case "UNMARK": {
                    String taskNum = commandArray[1].strip();
                    return new UnmarkCommand(taskNum);
                }
                case "EVENT": {
                    String taskDetails = commandArray[1].strip();
                    return new EventCommand(taskDetails);
                }
                case "DEADLINE": {
                    String taskDetails = commandArray[1].strip();
                    return new DeadlineCommand(taskDetails);
                }
                case "DELETE": {
                    String taskNum = commandArray[1].strip();
                    return new DeleteCommand(taskNum);
                }
                case "BYE": {
                    return new ByeCommand();
                }
                default: {
                    throw new DukeException("It's an INVALID COMMAND, follow the instruction and try again :-)");
                }
            }
    }
}