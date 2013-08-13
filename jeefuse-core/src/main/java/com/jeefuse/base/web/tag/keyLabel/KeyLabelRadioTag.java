package com.jeefuse.base.web.tag.keyLabel;

import java.util.Arrays;
import java.util.List;

import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * keyLabel列表渲染html Radio标签.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class KeyLabelRadioTag<T extends KeyLabel> extends AbstractKeyLabelRadioTag<T> {
	private static final long serialVersionUID = 1L;
	private List<T> keyLabels;

	public void setKeyLabels(List<T> keyLabels) {
		this.keyLabels = keyLabels;
	}

	public void setKeyLabels(T[] keyLabels) {
		if (null != keyLabels) {
			this.keyLabels = Arrays.asList(keyLabels);
		}
	}

	@Override
	public List<T> getKeyLabels() {
		return keyLabels;
	}

}
