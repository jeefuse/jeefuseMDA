package net.taylor.mda.generator.preferences;

import net.taylor.mda.generator.GeneratorPlugin;
import net.taylor.mda.generator.parse.entity.Config;

import org.eclipse.jface.preference.IPreferenceStore;

public class Preferences {

	public static IPreferenceStore getStore() {
		if (GeneratorPlugin.getDefault() == null) {
			return null;
		} else {
			return GeneratorPlugin.getDefault().getPreferenceStore();
		}
	}

	public static String getTemplateRoot() {
		if (getStore() == null) {
			return System.getProperty("user.home") + "/taylor/templates";
		} else {
			return getStore().getString(PreferenceConstants.P_TEMPLATE_ROOT);
		}
	}
	
	public static String getTemplateFilterBasePackage(){
		if (getStore() == null) {
			return Config.namespacePrefix;
		} else {
			return getStore().getString(PreferenceConstants.FILTER_BASE_PACKAGE);
		}
	}

	public static void setTemplateRootDefault() {
		if (getStore() != null) {
			getStore().setDefault(PreferenceConstants.P_TEMPLATE_ROOT,
					System.getProperty("user.home") + "/taylor/templates");
		}
	}

	public static boolean isPluginIncluded(String name) {
		if (getStore() == null) {
			return true;
		} else {
			return getStore().getBoolean(name + PreferenceConstants.INCLUDE);
		}
	}

	public static void setIncludePluginDefault(String plugin) {
		if (getStore() != null) {
			getStore().setDefault(plugin + PreferenceConstants.INCLUDE, "true");
		}
	}

	public static String getSuffix(String name) {
		if (getStore() == null) {
			return name;
		} else {
			return getStore().getString(name + PreferenceConstants.SUFFIX);
		}
	}

	public static boolean isSuffixIncluded(String name) {
		if (getStore() == null) {
			return true;
		} else {
			return getStore().getBoolean(name + PreferenceConstants.INCLUDE);
		}
	}

	public static void setSuffixDefault(String suffix) {
		if (getStore() != null) {
			getStore().setDefault(suffix + PreferenceConstants.SUFFIX, suffix);
			getStore().setDefault(suffix + PreferenceConstants.INCLUDE, "true");
		}
	}

	public static boolean isIgnoreSkip() {
		if (getStore() == null) {
			return false;
		} else {
			return getStore().getBoolean(PreferenceConstants.IGNORE_SKIP);
		}
	}

	public static boolean isSkipBackup() {
		if (getStore() == null) {
			return false;
		} else {
			return getStore().getBoolean(PreferenceConstants.SKIP_BACKUP);
			
		}
	}
}
