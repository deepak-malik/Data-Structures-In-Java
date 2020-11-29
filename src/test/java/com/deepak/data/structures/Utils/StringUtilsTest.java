/**
 * Data-Structures-In-Java
 * StringUtilsTest.java
 */
package com.deepak.data.structures.Utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for String Utility functions
 * 
 * @author Deepak
 */
public class StringUtilsTest {

	/**
	 * Test cases to check of string is empty
	 */
	@Test
	public void testIsEmpty() {
		Assert.assertTrue(StringUtils.isEmpty(null));
		Assert.assertTrue(StringUtils.isEmpty(""));
		Assert.assertFalse(StringUtils.isEmpty(" "));
		Assert.assertFalse(StringUtils.isEmpty("bob"));
		Assert.assertFalse(StringUtils.isEmpty(" bob "));
	}

	/**
	 * Test case to check if any string is empty in array
	 */
	@Test
	public void testIsAnyEmpty() {
		Assert.assertTrue(StringUtils.isAnyEmpty((CharSequence)null));
		Assert.assertTrue(StringUtils.isAnyEmpty(null, "foo"));
		Assert.assertTrue(StringUtils.isAnyEmpty("", "bar"));
		Assert.assertTrue(StringUtils.isAnyEmpty("bob", ""));
		Assert.assertTrue(StringUtils.isAnyEmpty("  bob  ", null));
		Assert.assertFalse(StringUtils.isAnyEmpty(" ", "bar"));
		Assert.assertFalse(StringUtils.isAnyEmpty("foo", "bar"));
	}

	/**
	 * Test case to check if a String is blank
	 */
	@Test
	public void testIsBlank() {
		Assert.assertTrue(StringUtils.isBlank(null));
		Assert.assertTrue(StringUtils.isBlank(""));
		Assert.assertTrue(StringUtils.isBlank(" "));
		Assert.assertFalse(StringUtils.isBlank("bob"));
		Assert.assertFalse(StringUtils.isBlank("  bob  "));
	}

	/**
	 * Test case to check if any string is blank
	 */
	@Test
	public void testIsAnyBlank() {
		Assert.assertTrue(StringUtils.isAnyBlank((CharSequence)null));
		Assert.assertTrue(StringUtils.isAnyBlank(null, "foo"));
		Assert.assertTrue(StringUtils.isAnyBlank(null, null));
		Assert.assertTrue(StringUtils.isAnyBlank("", "bar"));
		Assert.assertTrue(StringUtils.isAnyBlank("bob", ""));
		Assert.assertTrue(StringUtils.isAnyBlank("  bob  ", null));
		Assert.assertTrue(StringUtils.isAnyBlank(" ", "bar"));
		Assert.assertFalse(StringUtils.isAnyBlank(new String[] {}));
		Assert.assertFalse(StringUtils.isAnyBlank("foo", "bar"));
	}

	/**
	 * Test case to check trimming of string
	 */
	@Test
	public void testTrim() {
		Assert.assertEquals(StringUtils.trim(null), null);
		Assert.assertEquals(StringUtils.trim(""), "");
		Assert.assertEquals(StringUtils.trim("     "), "");
		Assert.assertEquals(StringUtils.trim("abc"), "abc");
		Assert.assertEquals(StringUtils.trim("    abc    "), "abc");
	}

	/**
	 * Test case to check truncation of string
	 */
	@Test
	public void testTruncate() {
		Assert.assertEquals(StringUtils.truncate(null, 0), null);
		Assert.assertEquals(StringUtils.truncate(null, 2), null);
		Assert.assertEquals(StringUtils.truncate("", 4), "");
		Assert.assertEquals(StringUtils.truncate("abcdefg", 4), "abcd");
		Assert.assertEquals(StringUtils.truncate("abcdefg", 6), "abcdef");
		Assert.assertEquals(StringUtils.truncate("abcdefg", 7), "abcdefg");
		Assert.assertEquals(StringUtils.truncate("abcdefg", 8), "abcdefg");
	}

	/**
	 * Method to test equals
	 */
	@Test
	public void testEquals() {
		Assert.assertTrue(StringUtils.equals(null, null));
		Assert.assertTrue(StringUtils.equals("abc", "abc"));
		Assert.assertFalse(StringUtils.equals(null, "abc"));
		Assert.assertFalse(StringUtils.equals("abc", null));
		Assert.assertFalse(StringUtils.equals("abc", "ABC"));
	}

	/**
	 * Method to test equals ignore case 
	 */
	@Test
	public void testEqualsIgnoreCase() {
		Assert.assertTrue(StringUtils.equalsIgnoreCase(null, null));
		Assert.assertTrue(StringUtils.equalsIgnoreCase("abc", "abc"));
		Assert.assertFalse(StringUtils.equalsIgnoreCase(null, "abc"));
		Assert.assertFalse(StringUtils.equalsIgnoreCase("abc", null));
		Assert.assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
	}

	/**
	 * Method to test comparison of 2 strings
	 */
	@Test
	public void testCompare() {
		Assert.assertEquals(StringUtils.compare(null, null), 0);
		Assert.assertEquals(StringUtils.compare(null, "a"), -1);
		Assert.assertEquals(StringUtils.compare("a", null), 1);
		Assert.assertEquals(StringUtils.compare("abc", "abc"), 0);
		Assert.assertEquals(StringUtils.compare("a", "b"), -1);
		Assert.assertEquals(StringUtils.compare("b", "a"), 1);
		Assert.assertEquals(StringUtils.compare("ab", "abc"), -1);
	}

	/**
	 * Method to test index of in a string
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testIndexOf() {
		Assert.assertEquals(StringUtils.indexOf("aadjsjh", 'a'), 0);
		Assert.assertEquals(StringUtils.indexOf("aabaabaa", 'b'), 2);
		Assert.assertEquals(StringUtils.indexOf("aabaabaa", 'b', 0), 2);
		Assert.assertEquals(StringUtils.indexOf("aabaabaa", 'b', 3), 5);
		Assert.assertEquals(StringUtils.indexOf("aabaabaa", 'b', 9), -1);
		Assert.assertEquals(StringUtils.indexOf("aabaabaa", 'b', -1), 2);
		Assert.assertEquals(StringUtils.indexOf(null, 'a'), -1);
		Assert.assertEquals(StringUtils.indexOf("", 'a'), -1);
	}

}
