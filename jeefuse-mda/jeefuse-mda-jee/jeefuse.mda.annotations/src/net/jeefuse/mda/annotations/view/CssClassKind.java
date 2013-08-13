package net.jeefuse.mda.annotations.view;

public enum CssClassKind {
	text, title, file, image, textarea, content, lable, field, list, item;
	public String toParam() {
		switch (this) {
		case text:
			return "text";
		case title:
			return "title";
		case file:
			return "file";
		case image:
			return "image";
		case textarea:
			return "textarea";
		case content:
			return "content";
		case lable:
			return "lable";
		case field:
			return "field";
		case list:
			return "list";
		case item:
			return "item";
		}
		return "text";
	}
	
	public static CssClassKind valueOfParam(String param) {
		for (CssClassKind kind : values()) {
			if (kind.toParam().equals(param)) {
				return kind;
			}
		}
		return null;
	}
}
