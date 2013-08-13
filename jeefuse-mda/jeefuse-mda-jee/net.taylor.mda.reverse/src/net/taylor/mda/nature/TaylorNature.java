package net.taylor.mda.nature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.taylor.mda.builder.ModelSynchronizer;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class TaylorNature implements IProjectNature {

	private IProject project;

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public void configure() throws CoreException {
		addBuilderToProject(getProject());
	}

	public void deconfigure() throws CoreException {
		removeBuilderFromProject(getProject());
	}

	protected void addBuilderToProject(IProject project) {
		// cannot modify closed project
		if (!project.isOpen()) {
			return;
		}

		// get description
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			e.printStackTrace();
			return;
		}

		// look for builders
		ICommand[] cmds = description.getBuildSpec();
		for (int i = 0; i < cmds.length; i++) {
			if (cmds[i].getBuilderName().equals(ModelSynchronizer.BUILDER_ID)) {
				return;
			}
		}

		// associate builder
		ICommand newCmd = description.newCommand();
		newCmd.setBuilderName(ModelSynchronizer.BUILDER_ID);
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.add(newCmd);
		description.setBuildSpec(newCmds.toArray(new ICommand[newCmds.size()]));

		// save description
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected void removeBuilderFromProject(IProject project) {
		// cannot modify closed project
		if (!project.isOpen()) {
			return;
		}

		// get description
		IProjectDescription description;
		try {
			description = project.getDescription();
		} catch (CoreException e) {
			e.printStackTrace();
			return;
		}

		// look for builders
		int index = -1;
		ICommand[] cmds = description.getBuildSpec();
		for (int i = 0; i < cmds.length; i++) {
			if (cmds[i].getBuilderName().equals(ModelSynchronizer.BUILDER_ID)) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			return;
		}

		// remove builder
		List<ICommand> newCmds = new ArrayList<ICommand>();
		newCmds.addAll(Arrays.asList(cmds));
		newCmds.remove(index);
		description.setBuildSpec(newCmds.toArray(new ICommand[newCmds.size()]));

		// save description
		try {
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
}
