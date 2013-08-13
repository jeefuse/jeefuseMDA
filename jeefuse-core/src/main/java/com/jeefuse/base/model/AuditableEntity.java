package com.jeefuse.base.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 包含创建时间与更新时间和创建与更新的操作员信息的Entity基类.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
@MappedSuperclass
public abstract class AuditableEntity {
	private static final long serialVersionUID = 5576969121290871481L;
	
	@Column(updatable = false)
	private Date createTime; //创建时间
	
	@Column(updatable = false)
	private String createBy; //创建操作员的登录名
	
	//本属性只在update时有效,save时无效.
	@Column(insertable = false)
	private Date updateTime; //最后修改时间
	
	@Column(insertable = false)
	private String updateBy; //最后修改操作员的登录名
	
	public Date getCreateTime() {
		return createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
