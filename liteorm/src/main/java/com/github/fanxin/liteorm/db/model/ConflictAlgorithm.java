package com.github.fanxin.liteorm.db.model;

/**
 * @date 2014-08-07
 */

public enum ConflictAlgorithm {
    /**
     * The algorithm specified in the OR clause of an INSERT or UPDATE overrides
     * any algorithm specified in a CREATE TABLE. If no algorithm is specified
     * anywhere, the ABORT algorithm is used.
     */
    None(" "),
    /**
     * When an applicable constraint violation occurs, the ROLLBACK resolution
     * algorithm aborts the current SQL statement with an SQLITE_CONSTRAINT
     * error and rolls back the current transaction. If no transaction is active
     * (other than the implied transaction that is created on every command)
     * then the ROLLBACK resolution algorithm works the same as the ABORT algorithm.
     */
    Rollback(" OR ROLLBACK "),
    /**
     * When an applicable constraint violation occurs, the ABORT resolution algorithm
     * aborts the current SQL statement with an SQLITE_CONSTRAINT error and backs
     * out any changes made by the current SQL statement; but changes caused by
     * prior SQL statements within the same transaction are preserved and the
     * transaction remains active. This is the default behavior and the behavior
     * specified by the SQL standard.
     */
    Abort(" OR ABORT "),
    /**
     * When an applicable constraint violation occurs, the FAIL resolution algorithm
     * aborts the current SQL statement with an SQLITE_CONSTRAINT error. But the FAIL
     * resolution does not back out prior changes of the SQL statement that failed nor
     * does it end the transaction. For example, if an UPDATE statement encountered a
     * constraint violation on the 100th row that it attempts to update, then the first
     * 99 row changes are preserved but changes to rows 100 and beyond never occur.
     */
    Fail(" OR FAIL "),
    /**
     * When an applicable constraint violation occurs, the IGNORE resolution algorithm
     * skips the one row that contains the constraint violation and continues
     * processing subsequent rows of the SQL statement as if nothing went wrong. Other
     * rows before and after the row that contained the constraint violation are
     * inserted or updated normally. No error is returned when the IGNORE conflict
     * resolution algorithm is used.
     */
    Ignore(" OR IGNORE "),
    /**
     * When a UNIQUE constraint violation occurs, the REPLACE algorithm deletes
     * pre-existing rows that are causing the constraint violation prior to inserting
     * or updating the current row and the command continues executing normally. If a
     * NOT NULL constraint violation occurs, the REPLACE conflict resolution replaces
     * the NULL value with the default value for that column, or if the column has no
     * default value, then the ABORT algorithm is used. If a CHECK constraint violation
     * occurs, the REPLACE conflict resolution algorithm always works like ABORT.
     */
    Replace(" OR REPLACE ");

    private String algorithm;

    ConflictAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getAlgorithm() {
        return algorithm;
    }
}

