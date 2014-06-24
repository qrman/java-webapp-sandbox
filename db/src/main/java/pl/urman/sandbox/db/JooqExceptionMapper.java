package pl.urman.sandbox.db;

import pl.urman.sandbox.db.ex.KeyViolationException;

import org.jooq.ExecuteContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultExecuteListener;
import org.postgresql.util.PSQLException;

public class JooqExceptionMapper extends DefaultExecuteListener {

    @Override
    public void exception(ExecuteContext ctx) {
        RuntimeException exception = ctx.exception();
        if (exception instanceof DataAccessException) {
            if (exception.getCause() instanceof PSQLException) {
                PSQLException ex = (PSQLException) exception.getCause();
                String sqlState = ex.getSQLState();
                switch (sqlState) {
                    case "23505": {
                        throw new KeyViolationException(exception);
                    }
                }
            }
        }
        super.exception(ctx);
    }
}
