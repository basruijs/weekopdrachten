package main.exceptions;

public class NumberUnderZeroException extends Throwable{
    String message;

    public NumberUnderZeroException(String s) {
        this.message = s;
    }

    @Override
    public String toString() {
        return "NumberUnderZeroException{" +
                "message='" + message + '\'' +
                '}';
    }
}
