package com.jeefuse.base.model.validate;

import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.model.parse.ColumnField;

/**
 * 实体类验证工具.经测试ClassValidator会比javax.validate.Validator性能更好.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class ValidateUtil {

	//private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * 获取实体验证器.
	 */
/*	public static synchronized Validator getValidator() {
		if (null == validator) {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			validator = factory.getValidator();
		}
		return validator;
	}*/

	/**
	 * 获取实体验证器.
	 */
//	public static Validator getValidator() {
//		return validator;
//	}

	/**
	 * 验证实体对象,返回约束违反集合.
	 */
//	public static <T> Set<ConstraintViolation<T>> validate(T model) {
//		Set<ConstraintViolation<T>> constraintViolations = ValidateUtil.getValidator().validate(model);
//		return constraintViolations;
//	}


	/**
	 * 验证实体对象属性,返回约束违反集合.
	 * 
	 */
//	static public <T> Set<ConstraintViolation<T>> validateProperty(T model, ColumnField<T> columnField) {
//		Set<ConstraintViolation<T>> constraintViolations = ValidateUtil.getValidator().validateProperty(model,
//				columnField.getFieldName());
//		return constraintViolations;
//	}


	/**
	 * 获取验证失败信息.使用hibernate 的ClassValidator验证.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, ColumnField<?> columnField, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				String fieldLabel = columnField.getFieldLabelByName(invalidValue.getPropertyName());
				if (null != fieldLabel) {
					sb.append(fieldLabel + ": " + invalidValue.getMessage());
				} else {
					sb.append(invalidValue.getMessage());
				}
				sb.append(null == newLineChar ? "\n" : newLineChar);
			}
			return sb.toString();
		}
		return "";
	}

	/**
	 * 获取验证失败信息.设置换行符为<code><</code>br/>
	 */
	public static String getValidateMessageWithBR(InvalidValue[] invalidValues, ColumnField<?> columnField) {
		return getValidateMessage(invalidValues, columnField, "<br/>");
	}

}
