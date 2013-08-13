package net.taylor.mda.reverse;

import junit.framework.TestCase;

public class ReverseEngineerTestCase extends TestCase {

	private String M2_REPO = "C:/Documents and Settings/John/.m2/repository";//ResourcesPlugin.getWorkspace().getPathVariableManager().getValue("M2_REPO").toOSString();
	
	public ReverseEngineerTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHibernateProfile() throws Exception {
		ProfileReverseEngineer re = new ProfileReverseEngineer();
//		re.createProfile(M2_REPO + "/hibernate/hibernate-annotations/3.1beta8/hibernate-annotations-3.1beta8.jar", "Hibernate");
	}
	
	public void testCreateSeamProfile() throws Exception {
		ProfileReverseEngineer re = new ProfileReverseEngineer();
//		re.createProfile(M2_REPO + "/jboss/jboss-seam/1.0.beta2/jboss-seam-1.0.beta2.jar", "Seam");
	}

	public void testCreateJwsProfile() throws Exception {
		ProfileReverseEngineer re = new ProfileReverseEngineer();
//		re.createProfile(M2_REPO + "/beehive/wsm/1.0-alpha/wsm-1.0-alpha.jar", "Jws");
	}

	public void testCreatePersistenceProfile() throws Exception {
		ProfileReverseEngineer re = new ProfileReverseEngineer();
//		re.createProfile(M2_REPO + "/javax/persistence/ejb/3.0-public_draft/ejb-3.0-public_draft.jar", "Persistence");
	}

	public void testCreateEjbProfile() throws Exception {
		ProfileReverseEngineer re = new ProfileReverseEngineer();
//		re.createProfile(M2_REPO + "/hibernate/hibernate-annotations/3.1beta8/hibernate-annotations-3.1beta8.jar", "Hibernate");
//		re.createProfile(M2_REPO + "/javax/ejb/ejb/3.0-public_draft/ejb-3.0-public_draft.jar", "Ejb");
	}
}
