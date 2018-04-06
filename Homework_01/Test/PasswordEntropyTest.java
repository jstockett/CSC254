import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEntropyTest {
    @Test
    void main() {
    }

    @Test
    void countSpecialCharacters() {
        assertEquals(1, PasswordEntropy.countSpecialCharacters(" "));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("!"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("\""));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("#"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("$"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("%"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("&"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("'"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("("));
        assertEquals(1, PasswordEntropy.countSpecialCharacters(")"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("*"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("+"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters(","));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("-"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("."));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("/"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters(":"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters(";"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("<"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("="));
        assertEquals(1, PasswordEntropy.countSpecialCharacters(">"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("?"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("@"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("["));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("\\"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("]"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("^"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("_"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("`"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("{"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("|"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("}"));
        assertEquals(1, PasswordEntropy.countSpecialCharacters("`"));
        assertEquals(33, PasswordEntropy.countSpecialCharacters("! \"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"));
        assertEquals(0, PasswordEntropy.countSpecialCharacters("1234567890abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals(0, PasswordEntropy.countSpecialCharacters(""));
    }

    @Test
    void hasDigit() {
        assertTrue(PasswordEntropy.hasDigit("0"));
        assertTrue(PasswordEntropy.hasDigit("1"));
        assertTrue(PasswordEntropy.hasDigit("2"));
        assertTrue(PasswordEntropy.hasDigit("3"));
        assertTrue(PasswordEntropy.hasDigit("4"));
        assertTrue(PasswordEntropy.hasDigit("5"));
        assertTrue(PasswordEntropy.hasDigit("6"));
        assertTrue(PasswordEntropy.hasDigit("7"));
        assertTrue(PasswordEntropy.hasDigit("8"));
        assertTrue(PasswordEntropy.hasDigit("9"));
        assertFalse(PasswordEntropy.hasDigit(""));
        assertFalse(PasswordEntropy.hasDigit("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                " !\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~"));


    }

    @Test
    void hasUpperCase() {
        assertTrue(PasswordEntropy.hasUpperCase("A"));
        assertTrue(PasswordEntropy.hasUpperCase("B"));
        assertTrue(PasswordEntropy.hasUpperCase("C"));
        assertTrue(PasswordEntropy.hasUpperCase("D"));
        assertTrue(PasswordEntropy.hasUpperCase("E"));
        assertTrue(PasswordEntropy.hasUpperCase("F"));
        assertTrue(PasswordEntropy.hasUpperCase("G"));
        assertTrue(PasswordEntropy.hasUpperCase("H"));
        assertTrue(PasswordEntropy.hasUpperCase("I"));
        assertTrue(PasswordEntropy.hasUpperCase("J"));
        assertTrue(PasswordEntropy.hasUpperCase("K"));
        assertTrue(PasswordEntropy.hasUpperCase("L"));
        assertTrue(PasswordEntropy.hasUpperCase("M"));
        assertTrue(PasswordEntropy.hasUpperCase("N"));
        assertTrue(PasswordEntropy.hasUpperCase("O"));
        assertTrue(PasswordEntropy.hasUpperCase("P"));
        assertTrue(PasswordEntropy.hasUpperCase("Q"));
        assertTrue(PasswordEntropy.hasUpperCase("R"));
        assertTrue(PasswordEntropy.hasUpperCase("S"));
        assertTrue(PasswordEntropy.hasUpperCase("T"));
        assertTrue(PasswordEntropy.hasUpperCase("U"));
        assertTrue(PasswordEntropy.hasUpperCase("V"));
        assertTrue(PasswordEntropy.hasUpperCase("W"));
        assertTrue(PasswordEntropy.hasUpperCase("X"));
        assertTrue(PasswordEntropy.hasUpperCase("Y"));
        assertTrue(PasswordEntropy.hasUpperCase("Z"));
        assertTrue(PasswordEntropy.hasUpperCase("Dabcdefghijkl123456789!({}~./z:;<>=+"));
        assertFalse(PasswordEntropy.hasUpperCase("abcdefghijklmnopqrstuvwxyz !\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~"));
        assertFalse(PasswordEntropy.hasUpperCase(""));
    }

    @Test
    void hasLowerCase() {
        assertTrue(PasswordEntropy.hasLowerCase("a"));
        assertTrue(PasswordEntropy.hasLowerCase("b"));
        assertTrue(PasswordEntropy.hasLowerCase("c"));
        assertTrue(PasswordEntropy.hasLowerCase("d"));
        assertTrue(PasswordEntropy.hasLowerCase("e"));
        assertTrue(PasswordEntropy.hasLowerCase("f"));
        assertTrue(PasswordEntropy.hasLowerCase("g"));
        assertTrue(PasswordEntropy.hasLowerCase("h"));
        assertTrue(PasswordEntropy.hasLowerCase("i"));
        assertTrue(PasswordEntropy.hasLowerCase("j"));
        assertTrue(PasswordEntropy.hasLowerCase("k"));
        assertTrue(PasswordEntropy.hasLowerCase("l"));
        assertTrue(PasswordEntropy.hasLowerCase("m"));
        assertTrue(PasswordEntropy.hasLowerCase("n"));
        assertTrue(PasswordEntropy.hasLowerCase("o"));
        assertTrue(PasswordEntropy.hasLowerCase("p"));
        assertTrue(PasswordEntropy.hasLowerCase("q"));
        assertTrue(PasswordEntropy.hasLowerCase("r"));
        assertTrue(PasswordEntropy.hasLowerCase("s"));
        assertTrue(PasswordEntropy.hasLowerCase("t"));
        assertTrue(PasswordEntropy.hasLowerCase("u"));
        assertTrue(PasswordEntropy.hasLowerCase("v"));
        assertTrue(PasswordEntropy.hasLowerCase("w"));
        assertTrue(PasswordEntropy.hasLowerCase("x"));
        assertTrue(PasswordEntropy.hasLowerCase("y"));
        assertTrue(PasswordEntropy.hasLowerCase("z"));
        assertTrue(PasswordEntropy.hasLowerCase("aABCDEIFHI1234567890!@#$%^&*{}|?><"));
        assertFalse(PasswordEntropy.hasLowerCase(""));
        assertFalse(PasswordEntropy.hasLowerCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ !\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~" +
                "1234567890"));
    }

    @Test
    void trimmedLength() {
        assertEquals(0, PasswordEntropy.trimmedLength(""));
        assertEquals(7, PasswordEntropy.trimmedLength("abcdefg"));
        assertEquals(10, PasswordEntropy.trimmedLength("   1234567890   "));
        assertEquals(12, PasswordEntropy.trimmedLength("   12345  67890    "));
        assertEquals(13, PasswordEntropy.trimmedLength("abcdefghijklm      "));
    }

    @Test
    void truncateString() {
        assertEquals("Hello56j", PasswordEntropy.truncateString("Hello56j"));
        assertEquals("", PasswordEntropy.truncateString(""));
        assertEquals("abcdefghijklmnopqrst...", PasswordEntropy.truncateString("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void log2() {
        assertEquals(2.3219, PasswordEntropy.log2(5), .0001);
        assertEquals(3.5849, PasswordEntropy.log2(12), .0001);
        assertEquals(6.9886, PasswordEntropy.log2(127), .0001);
    }

    @Test
    void calculateRange() {
        assertEquals(0, PasswordEntropy.calculateRange(""));
        assertEquals(52, PasswordEntropy.calculateRange("Hello"));
        assertEquals(62, PasswordEntropy.calculateRange("Hello1"));
        assertEquals(63, PasswordEntropy.calculateRange("Hello1@"));
        assertEquals(7, PasswordEntropy.calculateRange("!@#$%^&"));
        assertEquals(10, PasswordEntropy.calculateRange("1234567890"));
        assertEquals(26, PasswordEntropy.calculateRange("dog"));

    }

    @Test
    void entropy() {
        assertEquals(0, PasswordEntropy.entropy(""));
        assertEquals(0, PasswordEntropy.entropy("1"));
        assertEquals(5, PasswordEntropy.entropy("ab"));
        assertEquals(33, PasswordEntropy.entropy("mountain"));
        assertEquals(60, PasswordEntropy.entropy("line@!172#H"));
        assertEquals(110, PasswordEntropy.entropy("Hoj71?>wak_ jcarB./"));
    }

    @Test
    void evaluateEntropy() {
        assertEquals("Very Weak", PasswordEntropy.evaluateEntropy(0));
        assertEquals("Very Weak", PasswordEntropy.evaluateEntropy(64));
        assertEquals("Weak", PasswordEntropy.evaluateEntropy(65));
        assertEquals("Weak", PasswordEntropy.evaluateEntropy(80));
        assertEquals("Moderate", PasswordEntropy.evaluateEntropy(81));
        assertEquals("Moderate", PasswordEntropy.evaluateEntropy(112));
        assertEquals("Strong", PasswordEntropy.evaluateEntropy(113));
        assertEquals("Strong", PasswordEntropy.evaluateEntropy(128));
        assertEquals("Very Strong", PasswordEntropy.evaluateEntropy(129));
        assertEquals("Very Strong", PasswordEntropy.evaluateEntropy(135));
    }

}