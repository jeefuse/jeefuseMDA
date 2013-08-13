package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.util.NameHelper;

public enum NameRuledSqlAsKind implements NameRuled<String> {
	tableAs("", "_")
	;
	
	private String preffix;
	private String suffix;

	private NameRuledSqlAsKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	@Override
	public String getRuleNamed(String element) {
		return NameHelper.uncapName(this.preffix+NameHelper.toUpperCamel(element)+ this.suffix);
	}

}
