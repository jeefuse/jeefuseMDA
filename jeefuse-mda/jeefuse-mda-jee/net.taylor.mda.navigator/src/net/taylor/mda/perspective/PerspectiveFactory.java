package net.taylor.mda.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String navId = "net.taylor.mda.ModelNavigator";
		String editArea = layout.getEditorArea();
		layout.addView(navId,
				IPageLayout.LEFT, 0.25f, editArea);
		layout.addView(IPageLayout.ID_OUTLINE,
				IPageLayout.BOTTOM, 0.66f, navId);//75
		layout.addView(IPageLayout.ID_PROP_SHEET,
				IPageLayout.BOTTOM, 0.66f, editArea);
	}
}
