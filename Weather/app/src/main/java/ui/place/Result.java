package ui.place;

public class Result<T> {
    private T data;
    private Exception exception;

    public Result(T data) {
        this.data = data;
        this.exception = null;
    }

    public Result(Exception exception) {
        this.data = null;
        this.exception = exception;
    }

    public boolean isSuccess() {
        return exception == null;
    }
    public Exception getException() {
        return exception;
    }
    public T getOrNull() {
        return data;
    }

    public Exception exceptionOrNull() {
        return exception;
    }
}
