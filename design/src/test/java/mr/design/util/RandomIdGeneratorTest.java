package mr.design.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String lastSubstrSplittedByDot = idGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
        assertEquals("field3", lastSubstrSplittedByDot);
        lastSubstrSplittedByDot = idGenerator.getLastSubstrSplittedByDot("field1");
        assertEquals("field1", lastSubstrSplittedByDot);

        lastSubstrSplittedByDot = idGenerator.getLastSubstrSplittedByDot("field1#field2#field3");
        assertEquals("field1#field2#field3", lastSubstrSplittedByDot);
    }

    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String lastSubstrSplittedByDot = idGenerator.getLastSubstrSplittedByDot("");
        assertEquals("", lastSubstrSplittedByDot);
        lastSubstrSplittedByDot = idGenerator.getLastSubstrSplittedByDot(null);
        assertNull(lastSubstrSplittedByDot);
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        assertNotNull(actualRandomString);
        assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            assertTrue(('0' <= c && '9' >= c) || ('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c));
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthLessThanZero() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        assertNull(actualRandomString);
    }
}
