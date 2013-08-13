package net.taylor.mda.generator.parse.stereotype;

import net.jeefuse.mda.annotations.MdaStereotype;
import net.taylor.mda.generator.parse.StereotypeUtil;

import org.eclipse.uml2.uml.NamedElement;

/**
 * 应用服务stereotype tools.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ServiceStereotypeUtil {

	/**
	 * 是否应用定型 impExcel.
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isApplied_impExcel(NamedElement element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.impExcel);
	}

	/**
	 * 是否应用定型 expExcel
	 * 
	 * @param element
	 * @return
	 */
	public static boolean isApplied_expExcel(NamedElement element) {
		return StereotypeUtil.isAppliedStereotype(element, MdaStereotype.expExcel);
	}

}
