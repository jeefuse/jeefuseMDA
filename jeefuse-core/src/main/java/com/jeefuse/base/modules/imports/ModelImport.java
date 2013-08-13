package com.jeefuse.base.modules.imports;

import java.util.List;

/**
 * 导入模板对象.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public interface ModelImport<T> {

	public List<T> importToModel();
}
