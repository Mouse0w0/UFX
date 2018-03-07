package com.github.mousesrc.ufx.util;

public interface MathUtils {

	static double min(double... values) {
		if (values.length == 0)
			throw new IllegalArgumentException();
		double min = values[0];
		for (int i = 1; i < values.length; i++)
			if (min > values[i])
				min = values[i];
		return min;
	}
	
	static double max(double... values) {
		if (values.length == 0)
			throw new IllegalArgumentException();
		double max = values[0];
		for (int i = 1; i < values.length; i++)
			if (max < values[i])
				max = values[i];
		return max;
	}
}
