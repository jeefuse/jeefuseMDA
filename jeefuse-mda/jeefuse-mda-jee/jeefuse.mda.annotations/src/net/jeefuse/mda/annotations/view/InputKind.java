package net.jeefuse.mda.annotations.view;

public enum InputKind {
	text, title, file, image, textarea, content,contenttab, radio, select, checkbox,datePicker, 
	//o2oSelect, o2oSelectPage, m2oSelect, m2oSelectPage, o2mCheckboxs, o2mCheckboxsTab, o2mCheckboxPage
	;

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
		case contenttab:
			return "contenttab";
		case radio:
			return "radio";
		case select:
			return "select";
		case checkbox:
			return "checkbox";
		case datePicker:
			return "datePicker";
//		case o2oSelect:
//			return "o2oSelect";
//		case o2oSelectPage:
//			return "o2oSelectPage";
//		case m2oSelect:
//			return "m2oSelect";
//		case m2oSelectPage:
//			return "m2oSelectPage";
//		case o2mCheckboxs:
//			return "o2mCheckboxs";
//		case o2mCheckboxsTab:
//			return "o2mCheckboxsTab";
//		case o2mCheckboxPage:
//			return "o2mCheckboxPage";
		}
		return "text";
	}

	public static InputKind valueOfParam(String param) {
		for (InputKind kind : values()) {
			if (kind.toParam().equals(param)) {
				return kind;
			}
		}
		return null;
	}
}
