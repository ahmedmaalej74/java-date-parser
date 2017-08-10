public class DateParserException extends Exception {
    public DateParserException(Exception e) {
        super(e);
    }

    public DateParserException(String err) {
        super(err);
    }
}