package com.jeefuse.base.modules.export.component.model;

import org.jmesa.view.ComponentFactory;

import com.jeefuse.base.modules.export.component.SimpleComponentFactory;

public class ModelTableFactory<T> extends AbstractModelTableFactory<T> {
	private ModelCellEditor<T> modelCellEditor;

	public ModelTableFactory(ModelCellEditor<T> modelCellEditor) {
		this.modelCellEditor = modelCellEditor;
	}

	@Override
	protected ComponentFactory getComponentFactory() {
		return new SimpleComponentFactory();
	}

	@Override
	protected ModelCellEditor<T> getModelCellEditor() {
		return modelCellEditor;
	}
}
