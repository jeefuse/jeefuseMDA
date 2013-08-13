package com.jeefuse.base.modules.export.exporter.cvs;

import org.jmesa.view.ComponentFactory;

import com.jeefuse.base.modules.export.component.model.AbstractModelTableFactory;
import com.jeefuse.base.modules.export.component.model.ModelCellEditor;

public class CsvModelTableFactory<T> extends AbstractModelTableFactory<T> {
	private ModelCellEditor<T> modelCellEditor;

	public CsvModelTableFactory(ModelCellEditor<T> modelCellEditor) {
		this.modelCellEditor = modelCellEditor;
	}

	@Override
	protected ComponentFactory getComponentFactory() {
		return new CsvComponentFactory();
	}

	@Override
	protected ModelCellEditor<T> getModelCellEditor() {
		return modelCellEditor;
	}
}
