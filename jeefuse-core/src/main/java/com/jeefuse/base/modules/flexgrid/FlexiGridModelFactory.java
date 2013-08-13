package com.jeefuse.base.modules.flexgrid;

import java.util.List;

public class FlexiGridModelFactory {

	public static FlexiGridModel createFlexiGridModel(int page, long total, List<?> list) {
		return new FlexiGridModel(page, total, list);
	}
}
