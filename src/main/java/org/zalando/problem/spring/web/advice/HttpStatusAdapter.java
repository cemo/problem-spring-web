package org.zalando.problem.spring.web.advice;

import java.util.Objects;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;

/**
 * An implementation of {@link javax.ws.rs.core.Response.StatusType} to map {@link HttpStatus}.
 */
public class HttpStatusAdapter implements Response.StatusType {

    private final HttpStatus status;

    public HttpStatusAdapter(HttpStatus status) {
        this.status = status;
    }

    @Override
    public int getStatusCode() {
        return status.value();
    }

    @Override
    public Family getFamily() {
        return Family.familyOf(status.value());
    }

    @Override
    public String getReasonPhrase() {
        return status.getReasonPhrase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpStatusAdapter)) {
            return false;
        }
        HttpStatusAdapter that = (HttpStatusAdapter) o;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(status);
    }
}