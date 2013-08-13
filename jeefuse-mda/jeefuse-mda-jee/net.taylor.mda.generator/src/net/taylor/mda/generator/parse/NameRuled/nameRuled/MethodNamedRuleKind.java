package net.taylor.mda.generator.parse.NameRuled.nameRuled;

import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.NamedElement;

/**
 * 获取方法命名.
 * 
 */
public enum MethodNamedRuleKind implements NameRuled<NamedElement> {
	/** 导入数据 */
	importDatas("importDatas", ""){
		public String getRuleNamed(NamedElement element){
			 return "importDatas";
		 }
	},
	getIndexServerUrl("get", "IndexServerUrl");

	private String preffix;
	private String suffix;

	private MethodNamedRuleKind(String preffix, String suffix) {
		this.preffix = preffix;
		this.suffix = suffix;
	}

	@Override
	public String getRuleNamed(NamedElement element) {
		return NameHelper.uncapName(this.preffix + NameHelper.getCapName(element) + this.suffix);
	}

}
