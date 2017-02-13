/**
 * Data-Structures-In-Java
 * StringBuilderTest.java
 */
package com.deepak.data.structures.Strings;

import org.junit.Assert;
import org.junit.Test;

import com.deepak.data.structures.Strings.CustomStringBuilder;

/**
 * Test cases for custom string builder implementation
 * 
 * @author Deepak
 */
public class StringBuilderTest {

	/**
	 * Test case to check implementation of String Builder
	 */
	@Test
	public void testStringBuilder() {
		CustomStringBuilder builder = new CustomStringBuilder();
		Assert.assertEquals(builder.toString(), "");
		builder.append("This is awesome !!");
		Assert.assertEquals(builder.toString(), "This is awesome !!");
	}

}
