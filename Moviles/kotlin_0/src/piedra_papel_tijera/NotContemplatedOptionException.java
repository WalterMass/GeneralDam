package piedra_papel_tijera;

public class NotContemplatedOptionException extends Exception {
    @Override
    public String toString() {
        return "NotContemplatedOptionException: "+this.getMessage();
    }

    public NotContemplatedOptionException(String message) {
        super(message);

    }
}
