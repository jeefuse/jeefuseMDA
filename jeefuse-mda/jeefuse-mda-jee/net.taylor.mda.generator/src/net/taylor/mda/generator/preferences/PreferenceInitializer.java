package net.taylor.mda.generator.preferences;

import java.util.Set;

import net.taylor.mda.generator.engine.Templates;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		Preferences.setTemplateRootDefault();

		Set<String> plugins = Templates.getPlugins();
		for (String plugin : plugins) {
			Preferences.setIncludePluginDefault(plugin);
		}

		Set<String> suffixes = Templates.getSuffixes();
		for (String suffix : suffixes) {
			Preferences.setSuffixDefault(suffix);
		}
	}
}
