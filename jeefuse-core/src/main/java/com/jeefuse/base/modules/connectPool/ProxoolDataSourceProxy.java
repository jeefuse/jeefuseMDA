package com.jeefuse.base.modules.connectPool;

import org.logicalcobwebs.proxool.ProxoolDataSource;

/**
 * 解决proxool数据库连接池houseKeepingSleepTime设置错误.
 */
public class ProxoolDataSourceProxy extends ProxoolDataSource {

	public void setHouseKeepingSleepTime(long houseKeepingSleepTime) {
		super.setHouseKeepingSleepTime(Integer.valueOf(String.valueOf(houseKeepingSleepTime)));
	}
}
