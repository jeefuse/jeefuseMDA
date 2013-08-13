package com.jeefuse.base.web.component.jmesa;

import org.jmesa.util.ItemUtils;
import org.jmesa.view.html.event.RowEvent;

public class SimpleRowEvent implements RowEvent {

	public String execute(Object item, int rowcount) {
		Object bean = ItemUtils.getItemValue(item, "bean");
		Object id = ItemUtils.getItemValue(bean, "id");
		return "loadPubUserDataByAuthority('"+id+"')";
	}

}
