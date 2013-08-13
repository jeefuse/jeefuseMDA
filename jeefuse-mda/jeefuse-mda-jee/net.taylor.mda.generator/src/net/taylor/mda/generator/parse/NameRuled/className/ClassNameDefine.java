package net.taylor.mda.generator.parse.NameRuled.className;

/**
 * 类名称、包名、类名的定义.
 * 
 */
public interface ClassNameDefine {

	/**
	 * 类名.
	 */
	public String getClassName();

	/**
	 * 首字母大写类名.
	 */
	public String getClassCapName();

	/**
	 * 首字母小写类名.
	 * 
	 * @return
	 */
	public String getClassUncapName();

	/**
	 * 全限定类名.
	 * 
	 * @return
	 */
	public String getClassQualifiedName();

	/**
	 * 全限定包名.
	 * 
	 * @return
	 */
	public String getPackageQualifiedName();

}
