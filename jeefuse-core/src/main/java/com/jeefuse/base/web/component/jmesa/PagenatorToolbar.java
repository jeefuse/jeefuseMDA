package com.jeefuse.base.web.component.jmesa;

import org.jmesa.view.html.toolbar.MaxRowsIncrementsSupport;
import org.jmesa.view.html.toolbar.MaxRowsItem;
import org.jmesa.view.html.toolbar.ToolbarImpl;
import org.jmesa.view.html.toolbar.ToolbarItemType;

/**分页工具栏.
 * @author  yonclv
 * @created 2009-8-20
 */
public class PagenatorToolbar extends ToolbarImpl implements MaxRowsIncrementsSupport{

    private int[] maxRowsIncrements;
    protected boolean enablePageNumbers = true;
    
    public PagenatorToolbar() {
	}

	public PagenatorToolbar(boolean enablePageNumbers) {
		this.enablePageNumbers = enablePageNumbers;
	}

	public int[] getMaxRowsIncrements() {
        return maxRowsIncrements;
    }

    public void setMaxRowsIncrements(int[] maxRowsIncrements) {
        this.maxRowsIncrements = maxRowsIncrements;
    }
    
    public void enablePageNumbers(boolean isEnabled) {
        this.enablePageNumbers = isEnabled;
    }
    
    @Override
    public String render() {
    	
        if (hasToolbarItems()) { // already has items
            return super.render();
        }
        
        addToolbarItem(ToolbarItemType.FIRST_PAGE_ITEM);
        addToolbarItem(ToolbarItemType.PREV_PAGE_ITEM);
        
        if (enablePageNumbers) {
            addToolbarItem(ToolbarItemType.PAGE_NUMBER_ITEMS);
        }
        
        addToolbarItem(ToolbarItemType.NEXT_PAGE_ITEM);
        addToolbarItem(ToolbarItemType.LAST_PAGE_ITEM);

        MaxRowsItem maxRowsItem = (MaxRowsItem) addToolbarItem(ToolbarItemType.MAX_ROWS_ITEM);
        if (getMaxRowsIncrements() != null) {
            maxRowsItem.setIncrements(getMaxRowsIncrements());
        }

        return super.render();
    }    
}
