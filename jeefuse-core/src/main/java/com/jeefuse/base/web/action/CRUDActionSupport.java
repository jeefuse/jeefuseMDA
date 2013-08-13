package com.jeefuse.base.web.action;

/**
 * Struts2中典型的 CRUD 操作的Action抽象基类. 默认执行list()方法.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
@SuppressWarnings("serial")
public abstract class CRUDActionSupport extends BaseAction {
	public static final String RELOAD = "reload";
	public static final String VIEW = "view";

	/**
	 * 默认action操作，默认指向list()方法.
	 */
	@Override
	public String execute() throws Exception {
		return list();
	}

	/**
	 * 显示Entity列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String list() throws Exception;

	/**
	 * 显示Entity详细.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String view() throws Exception;

	/**
	 * 输入或编辑Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String edit() throws Exception;

	/**
	 * 新增或更新Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String save() throws Exception;

	/**
	 * 删除Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String delete() throws Exception;

}
