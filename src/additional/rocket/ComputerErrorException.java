package additional.rocket;

public class ComputerErrorException extends Exception {
    public ComputerErrorException() { }
    public ComputerErrorException(String message) {
        super(message);
    }
}