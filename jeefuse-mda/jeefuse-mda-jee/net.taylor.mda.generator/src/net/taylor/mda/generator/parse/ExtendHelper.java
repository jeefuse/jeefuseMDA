package net.taylor.mda.generator.parse;

import java.util.Iterator;
import java.util.List;

import net.taylor.mda.generator.parse.entity.Config;
import net.taylor.mda.generator.parse.stereotype.KeyLabelStereotypeHelper;
import net.taylor.mda.generator.parse.stereotype.TreeStereotypeHelper;
import net.taylor.mda.generator.util.ImportHelper;
import net.taylor.mda.generator.util.NameHelper;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;

public class ExtendHelper {

	@SuppressWarnings("unchecked")
	public static String getImplementsIdEntityAndImplementsSerialize(Class uml2Class) {
		String extendsLitteral = "";
		String implementsLitteral = "";
		//extend classes
		List superClasses = uml2Class.getSuperClasses();
		if (superClasses.iterator().hasNext()) {
			Class superClass = (Class) superClasses.iterator().next();
			String superClassQualifiedName = NameHelper.getQualifiedName(superClass);
			if (extendsLitteral.equals(""))
				extendsLitteral = " extends " + ImportHelper.getImportedName(superClassQualifiedName);
			else
				extendsLitteral = extendsLitteral + ","+ ImportHelper.getImportManager().getImportedName(superClassQualifiedName);
		}
		if (!uml2Class.getSuperClasses().iterator().hasNext()) {
			ImportHelper.getImportedName(Config.base_IdEntityQualifiedName);
			ImportHelper.getImportedName("java.io.Serializable");
			Property idProperty=TreeStereotypeHelper.getProperty_id(uml2Class);
			if(null!=idProperty){
				implementsLitteral = " implements IdEntity<"+MdaHelper.getImportedFeatureType(idProperty)+">, Serializable";
			}else{
				implementsLitteral = " implements IdEntity, Serializable";
			}
		}
		//apply keyLabel
		if(KeyLabelStereotypeHelper.isApply(uml2Class)){
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements " + ImportHelper.getImportedName(Config.base_keyLabel);
				else
					implementsLitteral = ", implements " + ImportHelper.getImportedName(Config.base_keyLabel);
			else
				implementsLitteral = implementsLitteral + "," + ImportHelper.getImportedName(Config.base_keyLabel);
		}
		//apply tree
		if(TreeStereotypeHelper.isApply(uml2Class)){
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements " + ImportHelper.getImportedName(Config.base_TreeViewItem);
				else
					implementsLitteral = ", implements " + ImportHelper.getImportedName(Config.base_TreeViewItem);
			else
				implementsLitteral = implementsLitteral + "," + ImportHelper.getImportedName(Config.base_TreeViewItem);
		}
		//define interfaces
		List interfaces = uml2Class.getInterfaceRealizations();// TODO
		for (Iterator it = interfaces.iterator(); it.hasNext();) {
			Interface itf = (Interface) it.next();
			String itfQualifiedName = NameHelper.getQualifiedName(itf);
			if (implementsLitteral.equals(""))
				if (extendsLitteral.equals(""))
					implementsLitteral = " implements " + ImportHelper.getImportedName(itfQualifiedName);
				else
					implementsLitteral = ", implements " + ImportHelper.getImportedName(itfQualifiedName);
			else
				implementsLitteral = implementsLitteral + "," + ImportHelper.getImportedName(itfQualifiedName);
		}
		return extendsLitteral + implementsLitteral;
	}
}
