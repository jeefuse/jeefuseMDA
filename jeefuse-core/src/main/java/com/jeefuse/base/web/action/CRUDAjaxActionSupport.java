package com.jeefuse.base.web.action;

/**
 * Struts2中处理ajax请求的CRUD Action抽象基类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public abstract class CRUDAjaxActionSupport extends BaseAction {
	
	private static final long serialVersionUID = 398440284687918305L;

	/**
	 * 默认action操作，默认指向list()方法.
	 */
	@Override
	public String execute(){
		list();
		return null;
	}

	/**
	 * 显示Entity列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract void list();

	/**
	 * 显示Entity详细.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract void view();
	
	/**
	 * 输入或编辑Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract void edit();

	/**
	 * 新增或更新Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract void save();

	/**
	 * 删除Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract void delete();

}
