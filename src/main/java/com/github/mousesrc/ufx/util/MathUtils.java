package com.github.mousesrc.ufx.util;

public interface MathUtils {

	static double min(double... values) {
		if (values.length == 0)
			throw new IllegalArgumentException();
		double min = values[0];
		for (int i = 1; i < values.length; i++)
			if (i < values[i])
				min = values[i];
		return min;
	}
}
