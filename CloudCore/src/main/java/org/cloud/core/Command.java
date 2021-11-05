package org.cloud.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cloud.core.commands.*;
import org.cloud.core.dto.User;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command implements Serializable {
    private Object data;
    private CommandType type;

    public static Command authCommand(String login, String password) {
        Command command = new Command();
        command.data = new AuthCommandData(login, password);
        command.type = CommandType.AUTH;
        return command;
    }

    public static Command authOkCommand(String username) {
        Command command = new Command();
        command.data = new AuthOkCommandData(username);
        command.type = CommandType.AUTH_OK;
        return command;
    }

    public static Command authTimeOutCommand(String errorMessage) {
        Command command = new Command();
        command.type = CommandType.AUTH_TIME_OUT;
        command.data = new ErrorCommandData(errorMessage);
        return command;
    }

    public static Command regCommand(String login, String password, String username) {
        Command command = new Command();
        command.data = new User(login, password, username);
        command.type = CommandType.REG;
        return command;
    }

    public static Command errorCommand(String errorMessage) {
        Command command = new Command();
        command.type = CommandType.ERROR;
        command.data = new ErrorCommandData(errorMessage);
        return command;
    }

    public static Command sendPrepareFileCommand(SendFileCommand fileCommand) {
        Command command = new Command();
        command.type = CommandType.PREPARE_SEND_FILE;
        command.data = fileCommand;
        return command;
    }

    public static Command sendDiscardFileCommand(String message) {
        Command command = new Command();
        command.type = CommandType.DISCARD_FILE;
        command.data = message;
        return command;
    }

    public static Command sendFileCommand(SendFileCommand fileCommand) {
        Command command = new Command();
        command.type = CommandType.SEND_FILE;
        command.data = fileCommand;
        return command;
    }

    public static Command messageCommand(String message) {
        Command command = new Command();
        command.type = CommandType.MESSAGE;
        command.data = new MessageCommand(message);
        return command;
    }

    public static Command deleteFileCommand(String fileName) {
        Command command = new Command();
        command.type = CommandType.DELETE_FILE;
        command.data = new DeleteFileCommand(fileName);
        return command;
    }

    public static Command sendListFileResponseCommand(List<String> files) {
        Command command = new Command();
        command.type = CommandType.LIST_FILE_RESPONSE;
        command.data = new ListFilesCommand(files);
        return command;
    }

    public static Command sendListFileRequestCommand() {
        Command command = new Command();
        command.type = CommandType.LIST_FILE_REQUEST;
        return command;
    }

    public static Command sendDiskSpaceCommand(DiskSpaceCommand spaceCommand) {
        Command command = new Command();
        command.type = CommandType.SPACE_RESPONSE;
        command.data = spaceCommand;
        return command;
    }
}
