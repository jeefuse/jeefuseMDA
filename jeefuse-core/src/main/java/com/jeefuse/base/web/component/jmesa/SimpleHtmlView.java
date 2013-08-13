package com.jeefuse.base.web.component.jmesa;

import org.apache.commons.lang.StringUtils;
import org.jmesa.view.AbstractContextSupport;
import org.jmesa.view.View;
import org.jmesa.view.component.Table;
import org.jmesa.view.component.TableSupport;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.toolbar.Toolbar;
import org.jmesa.view.html.toolbar.ToolbarSupport;

public class SimpleHtmlView extends AbstractContextSupport implements View, ToolbarSupport, TableSupport{
	private HtmlTable table;
	private Toolbar toolbar;
	private SimpleHtmlSnippetsImpl snippets;
	
	public byte[] getBytes() {
		String render = (String) render();
		return render.getBytes();
	}

	public HtmlTable getTable() {
		 return table;
	}

	public void setTable(Table table) {
		   this.table = (HtmlTable) table;
	}

	public Toolbar getToolbar() {
		  return toolbar;
	}

	public void setToolbar(Toolbar toolbar) {
		  this.toolbar = toolbar;
	}
	
	/**
     * Return the HtmlSnippets object. If the snippets is null then the default one will be created.
     * 
     * @return The HtmlSnippets object.
     */
    public SimpleHtmlSnippetsImpl getHtmlSnippets() {
        if (snippets == null) {
            this.snippets = new SimpleHtmlSnippetsImpl(getTable(), getToolbar(), getCoreContext());
        }

        return snippets;
    }
    
	public Object render() {
		HtmlBuilder html = new HtmlBuilder();
		
		SimpleHtmlSnippetsImpl curSnippets = getHtmlSnippets();
		
		//div
		html.append(curSnippets.themeStart());

        //table
		html.append(curSnippets.tableStart());

        //toolbar
		html.append(curSnippets.toolbar());

        //grid
		html.tr(1).close();
		html.td(2).close();
		html.div().styleClass("grid");
        if (StringUtils.isNotBlank(table.getTableRenderer().getWidth())) {
        	html.style("width:"+table.getTableRenderer().getWidth());
        }
        html.close();
        html.table(1).cellpadding("0").cellspacing("0").style("width:100%").close();
        
        //filter
		html.append(curSnippets.filter());
        //header
		html.append(curSnippets.header());
        //body
		html.append(curSnippets.tbodyStart());
		html.append(curSnippets.body());
		html.append(curSnippets.tbodyEnd());
        
        html.tableEnd(1);
		html.tdEnd();
		html.trEnd(1);
		html.divEnd();
        //footer
		html.append(curSnippets.footer());

        //status bar
		html.append(curSnippets.statusBar());

        html.append(curSnippets.tableEnd());

        html.append(curSnippets.themeEnd());

        html.append(curSnippets.initJavascriptLimit());

        return html.toString();
	}


}
