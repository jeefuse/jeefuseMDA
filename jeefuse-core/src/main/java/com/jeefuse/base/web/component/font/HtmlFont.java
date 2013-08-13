package com.jeefuse.base.web.component.font;

/**
 * 构造 HTML FONT 标签,只构造Color属性.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum HtmlFont {
	black("black"),
	blue("blue"),
	cyan("cyan"),
	darkGray("darkGray"),
	gray("gray"),
	green("green"),
	lightGray("lightGray"),
	magenta("magenta"),
	orange("orange"),
	pink("pink"),
	red("red"),
	white("white"),
	purple("purple"),
	yellow("yellow");
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	private String color;

	private HtmlFont(String color) {
		this.color = color;
	}


	public String renderHtml(String value) {

		return new StringBuilder(32)
			    .append("<font color=\"")
				.append(this.getColor())
				.append("\">")
				.append(value)
				.append("</font>")
				.toString();
	}

	public String renderStyle(){
		return new StringBuilder(32)
		.append(" style=\"color:")
		.append(this.getColor())
		.append("\" ")
		.toString();
	}

}
