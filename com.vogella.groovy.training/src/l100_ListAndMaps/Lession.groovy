package l100_ListAndMaps


import org.junit.Test


class Lession {

	@Test
	void test01_IterateWithEach() {
		def products = ['GitHub', 'Confluence', 'Hipmunk', 'Outlook']

		// it is very common to iterate through lists. Can it get simpler than this?
		for (String s : products) {
			println s
		}
		// in Groovy it is
		products.each {println it}

		Map<String, String> idToNameMap = [333: 'Matthew', 233: 'Christopher', 133: 'Dominic']

		// suppose we needed to extract a list of IDs+Names from this map. In Java:
		List<String> javaIdListResult = new LinkedList<String>()
		for (Map.Entry<String, String> entry : idToNameMap) {
			javaIdListResult.add(entry.getKey() + entry.getValue())
		}

		// use the each {closure} method to do the same
		// http://groovy.codehaus.org/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
		def idListResult = []
		// ------------ START EDITING HERE ----------------------
		idToNameMap.each { key, value -> idListResult << "$key$value"}
		// ------------ STOP EDITING HERE  ----------------------
		assert idListResult == ['333Matthew', '233Christopher', '133Dominic']
	}

	@Test
	void test02_Ranges() {
		// Groovy allows you to create quick lists for sequential values. For example 5..10 or 'a'..'d'
		// Read at http://groovy.codehaus.org/Collections#Collections-Ranges

		// a simple example:
		def range = 5..10

		// Wwat will range equal?
		def expectedRange = []
		// ------------ START EDITING HERE ----------------------
		expectedRange = [5, 6, 7, 8, 9, 10]
		// ------------ STOP EDITING HERE  ----------------------
		assert range == expectedRange
	}

	@Test
	void test03_IterateOnRanges() {
		// just as you can iterate over lists, you can iterate over ranges.

		// Create a list of all odd letters (a, c, e, ... etc) using ranges

		// Tip: First created the range and afterwards iterative through it via the eachWithIndex {closure}
		// method. Use if (index % 2 == 0) rangeResult << value to add to the rangeResult

		// http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
		def rangeResult = []

		// ------------ START EDITING HERE ----------------------
		def range = 'a'..'z'
		range.eachWithIndex { value, index ->
			if (index % 2 == 0) rangeResult << value
		}
		// ------------ STOP EDITING HERE  ----------------------
		assert rangeResult == ['a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y']
	}

	@Test
	void test03_MapsInGroovy() {
		def map = [right: 'derecha', left: 'izquierda']

		// concatenate the two values of 'right' and 'left' into result to proceed using Groovy syntax
		def result
		// ------------ START EDITING HERE ----------------------
		result = map['right'] + map['left']
		// ------------ STOP EDITING HERE  ----------------------

		assert result.toCharArray().size() == 16
	}

	@Test
	void test04_Lists() {
		// in Java, list creation can be somewhat cumbersome:
		List<String> javaList = new ArrayList<>()
		javaList.add("King")
		javaList.add("Queen")
		javaList.add("Prince")

		// in Groovy the list creating is simplified:
		def groovyList = ['King', 'Prince']

		// add the missing item to the Groovy list. Pay attention to the order of the items.
		// Hint: you can use either Java's add(int, String) or Groovy's plus() method.
		// ------------ START EDITING HERE ----------------------
		groovyList = groovyList.plus(1, 'Queen')
		// ------------ STOP EDITING HERE  ----------------------

		// note how Groovy allows you to compare the *content* of the lists
		assert groovyList == javaList
	}



}
