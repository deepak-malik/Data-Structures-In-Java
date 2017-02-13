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

}
