package db.textual;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SqlIteratorTest {
    SqlIterator sqlIterator;
    String query;

    @BeforeEach
    void setUp() {
        query = "";
        sqlIterator = new SqlIterator(query);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void init() {
        // TODO : Rendre init() testable
        fail();
    }

    @Test
    void hasNext() {
        sqlIterator.getResults().add("Result");
        assertTrue(sqlIterator.hasNext());
    }

    @Test
    void next() {
        sqlIterator.getResults().add("Result");
        assertEquals(sqlIterator.next(), "Result");
    }

    @Test
    void reset() {
        sqlIterator.setCurrentPosition(5);
        sqlIterator.reset();
        assertEquals(sqlIterator.getCurrentPosition(), 0);
    }
}