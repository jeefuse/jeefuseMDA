package net.taylor.mda.reverse;

import junit.framework.TestCase;

import org.eclipse.core.runtime.NullProgressMonitor;

public class DatabaseReverseEngineerTestCase extends TestCase {

	public DatabaseReverseEngineerTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDb() throws Exception {
		DatabaseReverseEngineer re = new DatabaseReverseEngineer();
		re.createModel(new NullProgressMonitor(), 
			"C:/downloads/mysql/mysql-connector-java-3.1.13/mysql-connector-java-3.1.13/mysql-connector-java-3.1.13-bin.jar", 
			"org.gjt.mm.mysql.Driver",
			"jdbc:mysql://localhost/taylor-tracker?user=root&password=password",
			"%",
			"test");
		
//		jdbc:postgresql://localhost:port/database?user=fred&password=secret
//		jdbc:oracle:thin:user/password@localhost:1521:XE
	}
}
