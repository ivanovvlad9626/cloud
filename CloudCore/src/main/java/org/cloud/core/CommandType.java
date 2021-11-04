package org.cloud.core;

public enum CommandType {
    AUTH,
    AUTH_OK,
    AUTH_TIME_OUT,
    REG,
    ERROR,
    SEND_FILE,
    SENDER_FILE,
    DISCARD_FILE,
    SEND_FILE_APPROVE,
    PREPARE_SEND_FILE,
    DELETE_FILE,
    MESSAGE
}
