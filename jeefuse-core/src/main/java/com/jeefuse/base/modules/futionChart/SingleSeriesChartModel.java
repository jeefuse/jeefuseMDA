package com.jeefuse.base.modules.futionChart;

public interface SingleSeriesChartModel {

	/**
	 * 显示的名称,必需
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 显示的值,必需
	 * 
	 * @return
	 */
	public String getValue();

	/**
	 * 显示的颜色,可选
	 * 
	 * @return
	 */
	public String getColor();

	/**
	 * 点击所指向的连接.可选
	 * 
	 * @return
	 */
	public String getLink();

}
