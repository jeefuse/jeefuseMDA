package com.jeefuse.base.web.component.jmesa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.jmesa.limit.Limit;
import org.jmesa.limit.state.SessionState;
import org.jmesa.limit.state.State;
import org.jmesa.web.HttpServletRequestWebContext;
import org.jmesa.web.WebContext;
import org.jmesa.worksheet.Worksheet;
import org.jmesa.worksheet.WorksheetRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTableFacadeUtils {
	 private static final Logger logger = LoggerFactory.getLogger(SimpleTableFacadeUtils.class);

	    public static final String TABLE_REFRESHING = "tr_";
	    
	    private SimpleTableFacadeUtils() {}
	    
	    /**
	     * There needs to be a way to tell if the table is refreshing, as opposed to being run for the first time.
	     * 
	     * @param id The table identifier.
	     * @param webContext The web context.
	     * @return Is true if the table is being refreshed.
	     */
	    public static boolean isTableRefreshing(String id, WebContext webContext) {
	        String refreshing = webContext.getParameter(id + "_" + TABLE_REFRESHING);
	        if (StringUtils.isNotEmpty(refreshing) && refreshing.equals("true")) {
	            return true;
	        }
	        
	        return false;
	    }
	    
	    /**
	     * Filter the items by the rows in the worksheet.
	     * 
	     * @param items The collection of beans or maps.
	     * @param worksheet The current worksheet.
	     * @return The filtered items.
	     */
	    public static Collection<?> filterWorksheetItems(Collection<?> items, Worksheet worksheet) {
	        if (!worksheet.isFiltering()) {
	            return items;
	        }

	        Collection<WorksheetRow> worksheetRows = worksheet.getRows();

	        if (items.size() == worksheetRows.size()) {
	            return items;
	        }

	        List<Object> results = new ArrayList<Object>();

	        for (Object item : items) {
	            for (WorksheetRow worksheetRow : worksheetRows) {
	                String uniqueProperty = worksheetRow.getUniqueProperty().getName();
	                String uniquePropertyValue = worksheetRow.getUniqueProperty().getValue();
	                try {
	                    Object value = PropertyUtils.getProperty(item, uniqueProperty);
	                    if (value.toString().equals(uniquePropertyValue)) {
	                        results.add(item);
	                    }

	                } catch (Exception e) {
	                    logger.error("Had problems evaluating the items.", e);
	                }
	            }
	        }

	        return results;
	    }

	    /**
	     * Retrieve the Limit from the State implemenation.
	     * 
	     * @param id The table identifier.
	     * @param stateAttr The attribute used to retrieve the Limit.
	     * @param request The servlet request.
	     * @return The Limit stored by the State implementation.
	     */
	    public static Limit retrieveLimit(String id, String stateAttr, HttpServletRequest request) {
	        WebContext webContext = new HttpServletRequestWebContext(request);
	        State state = new SessionState(id, stateAttr, webContext);
	        return state.retrieveLimit();
	    }
}
