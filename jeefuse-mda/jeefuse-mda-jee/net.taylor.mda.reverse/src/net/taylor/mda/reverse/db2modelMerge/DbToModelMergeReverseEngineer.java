package net.taylor.mda.reverse.db2modelMerge;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.List;

import net.taylor.mda.reverse.db2model.DbToModelReverseEngineer;
import net.taylor.mda.reverse.db2model.config.Db2ModelXmlConfig;
import net.taylor.mda.reverse.db2model.config.Jdbc;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.Model;
import org.osgi.framework.Bundle;

public class DbToModelMergeReverseEngineer extends DbToModelReverseEngineer {
    
	public Model loadModel(String url){
		Model model = (Model) load(URI.createFileURI(url));
		List<String> profiles = getProfiles();
		for (String string : profiles) {
			out("importing profile: " + string);
			importProfile(model, string);
		}
		return model;
	}
	
	public void createMergeModel(IProgressMonitor monitor, String existModelFile,
			String modelConfigFile, String driverJarPath) {
		try {
			registerResourceFactories();
			//goal = "jar:file:/" + path + "/plugins/org.eclipse.uml2.uml.resources_<version>.jar!/"
			Bundle b = Platform.getBundle("org.eclipse.uml2.uml.resources");
			String location = b.getLocation();
			location = location.replace("reference", "jar");
			location = location + "!/";
			registerPathmaps(URI.createURI(location));
			//URI existModelUrl=URI.createURI(existModelFile);
			//URI existModelUrl=URI.createFileURI(existModelFile);
			out("Creating model...");
			//Model model = createModel(name, URI.createURI("model").appendSegment(name).appendFileExtension(UMLResource.FILE_EXTENSION));

			Model model=loadModel(existModelFile);
			// these are for unit testing
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/Persistence.profile.uml");
			// importProfile(
			// model,
			// "file://C:/workspaces/taylor/taylor.mda3.workspace/net.taylor.mda.profiles/profiles/types.profile.uml");

			//config 
			Db2ModelXmlConfig db2ModelConfig = new Db2ModelXmlConfig(modelConfigFile);
			Jdbc jdbc = db2ModelConfig.getJdbc();
			out("connection info :" + jdbc.toString());
			Connection connection = getConnection(driverJarPath, jdbc.getDriver(), jdbc.getUrl(), jdbc.getUsername(), jdbc.getPassword());
			DatabaseMetaData dm = connection.getMetaData();

			// TODO consider doing this instead
			// String[] types = {"TABLE"};
			// ResultSet rs = dm.getTables(null,null,"%",types);

			ResultSet catalogs = dm.getCatalogs();
			if (catalogs.next()) {
				processByCatalog(connection, dm, jdbc.getSchema(), monitor, model, db2ModelConfig.getImportList());
			} else {
				processBySchema(connection, dm, jdbc.getSchema(), monitor, model, db2ModelConfig.getImportList());
			}
			catalogs.close();
			connection.close();

			out("Saving model...");
			//return toInputStream(model, URI.createURI("model").appendSegment(name).appendFileExtension(UMLResource.FILE_EXTENSION));
			//return toInputStream(model, URI.createURI("model").appendSegment(name).appendFileExtension(umlresource.FILE_EXTENSION));
			// these are for unit testing
			save(model, URI.createFileURI(existModelFile));
			// return null;

		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
