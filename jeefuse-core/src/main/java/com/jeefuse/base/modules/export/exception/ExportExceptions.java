package com.jeefuse.base.modules.export.exception;

import java.util.Collection;

import org.jmesa.core.CoreContext;
import org.jmesa.limit.Limit;
import org.jmesa.view.View;
import org.jmesa.view.component.Table;
import org.jmesa.view.html.toolbar.Toolbar;

public class ExportExceptions {
	  private ExportExceptions() {}

	    static void validateCoreContextIsNull(CoreContext coreContext, String object) {
	        if (coreContext != null) {
	            throw new IllegalStateException(
	                "It is too late to set the " + object + ". You need to set the " + object + " before using the CoreContext.");
	        }
	    }

	    static void validateTableIsNull(Table table, String object) {
	        if (table != null) {
	            throw new IllegalStateException(
	                "It is too late to set the " + object + ". You need to set the " + object + " before using the Table.");
	        }
	    }

	    static void validateViewIsNull(View view, String object) {
	        if (view != null) {
	            throw new IllegalStateException(
	                "It is too late to set the " + object + ". You need to set the " + object + " before using the View.");
	        }
	    }

	    static void validateToolbarIsNull(Toolbar toolbar, String object) {
	        if (toolbar != null) {
	            throw new IllegalStateException(
	                "It is too late to set the " + object + ". You need to set the " + object + " before using the Toolbar.");
	        }
	    }

	    static void validateLimitIsNull(Limit limit, String object) {
	        if (limit != null) {
	            throw new IllegalStateException(
	                "It is too late to set the " + object + ". You need to set the " + object + " before using the Limit.");
	        }
	    }

	    static void validateColumnPropertiesIsNotNull(String[] columnProperties) {
	        if (columnProperties == null || columnProperties.length == 0) {
	            throw new IllegalStateException(
	                "The column properties are null. You need to set the columnProperties, or build the Table with the factory.");
	        }
	    }

	    static void validateRowSelectIsNotNull(Limit limit) {
	        if (limit.getRowSelect() == null) {
	            throw new IllegalStateException(
	                "The RowSelect is null. You need to set the totalRows on the facade.");
	        }
	    }

	    static void validateItemsIsNull(Collection<?> items) {
	        if (items != null) {
	            throw new IllegalStateException(
	                "It is too late to set editable. You need to set editable before using the Limit.");
	        }
	    }

	    static void validateItemsIsNotNull(Collection<?> items) {
	        if (items == null) {
	            throw new IllegalStateException("The items are null. You need to set the items on the facade.");
	        }
	    }
}
