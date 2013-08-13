package net.taylor.mda.generator.parse.stereotype;

public class RelStereotypeModel {

	private String listKey;
	private String listLabel;
	private org.eclipse.uml2.uml.Class targetClass;
	private org.eclipse.uml2.uml.Class relMediateClass;

	public String getListKey() {
		return listKey;
	}

	public void setListKey(String listKey) {
		this.listKey = listKey;
	}

	public String getListLabel() {
		return listLabel;
	}

	public void setListLabel(String listLabel) {
		this.listLabel = listLabel;
	}


	public org.eclipse.uml2.uml.Class getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(org.eclipse.uml2.uml.Class targetClass) {
		this.targetClass = targetClass;
	}


	public org.eclipse.uml2.uml.Class getRelMediateClass() {
		return relMediateClass;
	}

	public void setRelMediateClass(org.eclipse.uml2.uml.Class relMediateClass) {
		this.relMediateClass = relMediateClass;
	}


}
