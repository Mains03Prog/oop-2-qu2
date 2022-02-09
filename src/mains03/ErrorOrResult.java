package mains03;

import java.util.NoSuchElementException;

public class ErrorOrResult {
    static ErrorOrResult success(int result) {
        return new ErrorOrResult(false, null, result);
    }

    static ErrorOrResult failed(String error) {
        return new ErrorOrResult(true, error, 0);
    }

    private final boolean failed;
    private final String error;
    private final int result;

    private ErrorOrResult(boolean failed, String error, int result) {
        this.failed = failed;
        this.error = error;
        this.result = result;
    }

    boolean failed() {
        return failed;
    }

    String error() {
        if (!failed)
            throw new NoSuchElementException();
        return error;
    }

    int result() {
        if (failed)
            throw new NoSuchElementException();
        return result;
    }
}
