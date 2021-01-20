package com.diffblue.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Helper to find lines satisfying given properties.
 */
public final class Lines {
	private Lines() {
	}

	public static Set<CodeLine> findLinesCoveredByMultipleTests(CodeAnalyzer analyzer, Set<CodeTest> tests) {
		Map<CodeLine, Integer> countPerLine = new HashMap<>();
		for (CodeTest test : tests) {
			for (CodeLine line : analyzer.runTest(test)) {
				countPerLine.merge(line, 1, Integer::sum);
			}
		}
		return countPerLine.entrySet().stream().filter(e -> e.getValue() >= 2).map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}
}
