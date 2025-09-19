package co.com.bancolombia.r2dbc.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class FieldNotFoundException extends DataIntegrityViolationException {
    public FieldNotFoundException(String msg) {
        super(msg);
    }

}
