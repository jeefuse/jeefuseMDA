package com.jeefuse.base.web.component.jmesa;

import java.util.Collection;

import org.jmesa.core.CoreContext;
import org.jmesa.core.CoreContextFactory;
import org.jmesa.core.CoreContextImpl;
import org.jmesa.core.Items;
import org.jmesa.core.filter.FilterMatcher;
import org.jmesa.core.filter.FilterMatcherRegistry;
import org.jmesa.core.filter.FilterMatcherRegistryImpl;
import org.jmesa.core.filter.MatcherKey;
import org.jmesa.core.filter.RowFilter;
import org.jmesa.core.filter.SimpleRowFilter;
import org.jmesa.core.filter.StringFilterMatcher;
import org.jmesa.core.message.Messages;
import org.jmesa.core.message.MessagesFactory;
import org.jmesa.core.preference.Preferences;
import org.jmesa.core.preference.PreferencesFactory;
import org.jmesa.core.sort.ColumnSort;
import org.jmesa.core.sort.MultiColumnSort;
import org.jmesa.limit.Limit;
import org.jmesa.util.SupportUtils;
import org.jmesa.web.WebContext;
import org.jmesa.worksheet.Worksheet;

/**实现 jmesa 的 coreContextFactory.
 * @author  yonclv
 * @created 2009-8-25
 */
public class SimpleCoreContextFactory implements CoreContextFactory {
	private WebContext webContext;
	private Preferences preferences;
	private Messages messages;
	private boolean autoFilter;
	private boolean autoSort;
	private FilterMatcherRegistry registry;
	private RowFilter rowFilter;
	private ColumnSort columnSort;

	public SimpleCoreContextFactory(boolean autoFilter, boolean autoSort,
			WebContext webContext) {
		this.autoFilter = autoFilter;
		this.autoSort = autoSort;
		this.webContext = webContext;
	}

	protected FilterMatcherRegistry getFilterMatcherRegistry() {
		if (registry == null) {
			registry = new FilterMatcherRegistryImpl();
			StringFilterMatcher stringFilterMatcher = new StringFilterMatcher();
			registry.addFilterMatcher(new MatcherKey(Object.class),stringFilterMatcher);
		}
		return registry;
	}

	public void addFilterMatcher(MatcherKey key, FilterMatcher matcher) {
		SupportUtils.setWebContext(matcher, webContext);
		getFilterMatcherRegistry().addFilterMatcher(key, matcher);
	}

	public CoreContext createCoreContext(Collection<?> items, Limit limit,Worksheet worksheet) {
		if(autoFilter){
			rowFilter=getRowFilter();
		}
		if(autoSort){
			columnSort =getColumnSort() ;
		}
		Items itemsImpl = new SimpleItems(items, limit,rowFilter,columnSort);
		CoreContext coreContext = new CoreContextImpl(itemsImpl,limit,worksheet,getPreferences(), getMessages());
		return coreContext;
	}

	protected ColumnSort getColumnSort() {
		if (columnSort == null) {
			columnSort = new MultiColumnSort();
		}

		return columnSort;
	}

	public void setColumnSort(ColumnSort columnSort) {
		this.columnSort = columnSort;
	}

	protected Messages getMessages() {
		if (messages == null) {
			messages = MessagesFactory.getMessages(webContext);
		}
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	protected Preferences getPreferences() {
		if (preferences == null) {
			preferences = PreferencesFactory.getPreferences(webContext);
		}
		return preferences;
	}

	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}

	protected RowFilter getRowFilter() {
		if (rowFilter == null) {
			rowFilter = new SimpleRowFilter();
		}
		SupportUtils.setFilterMatcherRegistry(rowFilter,getFilterMatcherRegistry());
		return rowFilter;
	}

	public void setRowFilter(RowFilter rowFilter) {
		 this.rowFilter = rowFilter;
	}

}
