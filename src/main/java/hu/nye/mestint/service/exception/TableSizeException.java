package hu.nye.mestint.service.exception;


public class TableSizeException extends RuntimeException {

    public TableSizeException(String message) {
        super(message);
    }
}