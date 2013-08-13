package com.jeefuse.base.modules.futionChart;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class SingleSeriesChartRender<T extends SingleSeriesChartModel> implements FutionChartRender {

	private static final String BASE_FONT_SIZE = "13";
	protected String caption;
	protected String subCaption;
	protected String xAxisName;
	protected String yAxisName;
	protected String showNames;
	protected String decimalPrecision;
	protected String formatNumberScale;
	protected String numberSuffix;
	protected List<T> seriesChartModels;
	protected String baseFontSize = BASE_FONT_SIZE;

	public SingleSeriesChartRender(String caption, String xAxisName, String yAxisName,
			List<T> seriesChartModels) {
		this.caption = caption;
		this.xAxisName = xAxisName;
		this.yAxisName = yAxisName;
		this.seriesChartModels = seriesChartModels;
	}

	public String renderXml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<graph caption='");
		sb.append(caption);
		if (StringUtils.isNotBlank(subCaption)) {
			sb.append("' subCaption='");
			sb.append(subCaption);
		}
		if (StringUtils.isNotBlank(xAxisName)) {
			sb.append("' xAxisName='");
			sb.append(xAxisName);
		}
		if (StringUtils.isNotBlank(yAxisName)) {
			sb.append("' yAxisName='");
			sb.append(yAxisName);
		}
		if (StringUtils.isNotBlank(showNames)) {
			sb.append("' showNames='");
			sb.append(showNames);
		}
		if (StringUtils.isNotBlank(decimalPrecision)) {
			sb.append("' decimalPrecision='");
			sb.append(decimalPrecision);
		}
		if (StringUtils.isNotBlank(formatNumberScale)) {
			sb.append("' formatNumberScale='");
			sb.append(formatNumberScale);
		}
		if (StringUtils.isNotBlank(numberSuffix)) {
			sb.append("' numberSuffix='");
			sb.append(numberSuffix);
		}
		sb.append("' baseFontSize='");
		sb.append(baseFontSize);
		sb.append("'>");
		if (null != seriesChartModels && !seriesChartModels.isEmpty()) {
			FusionChartsHelper chartsHelper = new FusionChartsHelper();
			for (SingleSeriesChartModel model : seriesChartModels) {
				sb.append("<set name='");
				sb.append(model.getName());
				sb.append("' value='");
				sb.append(model.getValue());
				if (StringUtils.isNotBlank(model.getLink())) {
					sb.append("' link='");
					sb.append(model.getLink());
				}
				sb.append("' color='");
				if (StringUtils.isNotBlank(model.getColor())) {
					sb.append(model.getColor());
				} else {
					sb.append(chartsHelper.getFCColor());
				}
				sb.append("' />");
			}
		}
		sb.append("</graph>");
		return sb.toString();
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getxAxisName() {
		return xAxisName;
	}

	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}

	public String getyAxisName() {
		return yAxisName;
	}

	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}

	public String getShowNames() {
		return showNames;
	}

	public void setShowNames(String showNames) {
		this.showNames = showNames;
	}

	public String getDecimalPrecision() {
		return decimalPrecision;
	}

	public void setDecimalPrecision(String decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	public String getFormatNumberScale() {
		return formatNumberScale;
	}

	public void setFormatNumberScale(String formatNumberScale) {
		this.formatNumberScale = formatNumberScale;
	}

	public List<T> getSeriesChartModels() {
		return seriesChartModels;
	}

	public void setSeriesChartModels(List<T> seriesChartModels) {
		this.seriesChartModels = seriesChartModels;
	}

	public String getBaseFontSize() {
		return baseFontSize;
	}

	public void setBaseFontSize(String baseFontSize) {
		this.baseFontSize = baseFontSize;
	}

}
