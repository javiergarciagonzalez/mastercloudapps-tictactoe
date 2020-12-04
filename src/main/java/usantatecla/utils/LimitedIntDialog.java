package usantatecla.utils;

public class LimitedIntDialog {

    private static final String ERROR_MESSAGE = "Invalid number";
    private final ClosedInterval LIMITS;

    public LimitedIntDialog(int min, int max) {
        this.LIMITS = new ClosedInterval(min, max);
    }

    public int read(String message) {
        assert message != null;

        boolean error;
        int value;
        do {
            value = Console.getInstance().readInt(message + "? " + this.LIMITS + ": ");
            error = !this.LIMITS.isIncluded(value);
            if (error) {
                Console.getInstance().writeln(LimitedIntDialog.ERROR_MESSAGE);
            }
        } while (error);
        return value;
    }

}
