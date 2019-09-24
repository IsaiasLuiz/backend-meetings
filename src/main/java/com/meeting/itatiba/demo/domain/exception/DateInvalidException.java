package com.meeting.itatiba.demo.domain.exception;

public class DateInvalidException extends Exception {

    public DateInvalidException() {
    }

    public DateInvalidException(final String s) {
        super(s);
    }

    public DateInvalidException(final String s, final Throwable throwable) {
        super(s, throwable);
    }

    public DateInvalidException(final Throwable throwable) {
        super(throwable);
    }

    public DateInvalidException(final String s, final Throwable throwable, final boolean b, final boolean b1) {
        super(s, throwable, b, b1);
    }
}
