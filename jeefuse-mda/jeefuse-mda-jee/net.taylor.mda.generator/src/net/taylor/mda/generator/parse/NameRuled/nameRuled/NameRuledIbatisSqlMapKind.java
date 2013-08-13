package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.NamedElement;

public enum NameRuledIbatisSqlMapKind implements NameRuled<NamedElement> {
	findListIds("find", "findListIds"),
	findListFromClause("find","findListFromSql"),
	findListCount("find","findListCount"),
	findListByIds("find","findListByIds"),
	get("get", ""),
	getAll("getAll",""),
	update("update", ""),
	updateById("update", "ById"),
	insert("insert", ""), 
	deleteById("delete", "ById"),
	deleteByIdList("delete", "ByIdList"),
	deleteAll("deleteAll", ""),
	tableMarkAs("_",""),
	resultMap("","Result")
	
	;

	private String preffix;
	private String suffix;

	private NameRuledIbatisSqlMapKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	@Override
	public String getRuleNamed(NamedElement element) {
		return NameHelper.uncapName(this.preffix+NameHelper.getCapName(element)+ this.suffix);
	}

}
