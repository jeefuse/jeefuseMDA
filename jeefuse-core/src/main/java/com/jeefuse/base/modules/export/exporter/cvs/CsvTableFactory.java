
package com.jeefuse.base.modules.export.exporter.cvs;

import org.jmesa.view.ComponentFactory;

import com.jeefuse.base.modules.export.component.SimpleTableFactory;


public class CsvTableFactory extends SimpleTableFactory {
    public CsvTableFactory() {
    }

    @Override
    protected ComponentFactory getComponentFactory() {
        return new CsvComponentFactory();
    }
}
