package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.parse.stereotype.TableStereotypeHelper;

public enum NameRuledTableKind implements NameRuled<org.eclipse.uml2.uml.Class> {
	SEQ("SEQ_", ""), ;

	private String preffix;
	private String suffix;

	private NameRuledTableKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	@Override
	public String getRuleNamed(org.eclipse.uml2.uml.Class element) {
		String tableName = TableStereotypeHelper.getApplyTable_name(element);
		return this.preffix + tableName + this.suffix;
	}

}
