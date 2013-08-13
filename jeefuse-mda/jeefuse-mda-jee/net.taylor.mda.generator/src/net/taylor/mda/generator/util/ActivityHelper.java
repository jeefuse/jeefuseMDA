package net.taylor.mda.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.taylor.mda.generator.Console;
import net.taylor.mda.generator.GeneratorPlugin;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;

public class ActivityHelper {

	//---------------------------------------------------------------
	// main
	//---------------------------------------------------------------
	
	public static Iterator<ActivityNode> getNodes(Activity activity) {
		List<ActivityNode> list = new ArrayList<ActivityNode>();
		Iterator<ActivityNode> i = activity.getNodes().iterator();
		while (i.hasNext()) {
			ActivityNode node = i.next();
			if (!isInitialNode(node) && !isFlowFinalNode(node)
					&& !isScheduled(node) && !isOnlyTrigger(node)
					&& node.getIncomings().size() > 0) {
				list.add(node);
			}
		}
		return list.iterator();
	}

	public static Map<String, List<ActivityEdge>> incoming(ActivityNode node) {
		Map<String, List<ActivityEdge>> map = new HashMap<String, List<ActivityEdge>>();
		List<ActivityEdge> edges = node.getIncomings();
		for (ActivityEdge edge : edges) {
			if (isOperation(edge.getSource())) {
				List<ActivityEdge> list = map.get("invoked");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("invoked", list);
				}
				list.add(edge);
			} else 
			if (isTask(edge.getSource())) {
				List<ActivityEdge> list = map.get("completed");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("completed", list);
				}
				list.add(edge);
			} else 
			if (isTimer(edge.getSource())) {
				List<ActivityEdge> list = map.get("expired");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("expired", list);
				}
				list.add(edge);
			} else 
			if (isFork(edge.getSource())) {
				List<ActivityEdge> list = map.get("forked");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("forked", list);
				}
				list.add(edge);
			} else 
			if (isJoin(edge.getSource())) {
				List<ActivityEdge> list = map.get("joined");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("joined", list);
				}
				list.add(edge);
			} else if (isCondition(edge)){
				List<ActivityEdge> list = map.get("conditions");
				if (list == null) {
					list = new ArrayList<ActivityEdge>();
					map.put("conditions", list);
				}
				list.add(edge);
			}
		}
		return map;
	}

	public static boolean isCondition(ActivityEdge edge) {
		return edge.getGuard() != null;
	}

	public static boolean isInitialNode(ActivityNode node) {
		return node instanceof InitialNode;
	}
	
	public static boolean isFlowFinalNode(ActivityNode node) {
		return node instanceof FlowFinalNode;
	}

	public static boolean isTrigger(ActivityNode node) {
		List<ActivityEdge> list = node.getIncomings();
		// are all edges initial
		for (ActivityEdge edge : list) {
			if (isInitialNode(edge.getSource())) {
				return true;
			}
		}
		return false;
	}

	public static boolean isOnlyTrigger(ActivityNode node) {
		List<ActivityEdge> list = node.getIncomings();
		// are all edges initial
		boolean trigger = false;
		for (ActivityEdge edge : list) {
			if (isInitialNode(edge.getSource())) {
				trigger = true;
			} else {
				trigger = false;
			}
		}
		return trigger;
	}

	public static boolean isOperation(ActivityNode node) {
		return node instanceof CallOperationAction;
	}

	public static boolean isTask(ActivityNode node) {
		return node instanceof CallBehaviorAction;
	}

	public static boolean isJoin(ActivityNode node) {
		return node instanceof JoinNode;
	}

	public static boolean isFork(ActivityNode node) {
		return node instanceof ForkNode;
	}

	public static boolean isTimer(ActivityNode node) {
		return node instanceof AcceptEventAction
				&& StereotypeHelper.isStereotypeApplied(node, "Timer");
	}

	public static boolean isScheduled(ActivityNode node) {
		return node instanceof AcceptEventAction
				&& StereotypeHelper.isStereotypeApplied(node, "Scheduled");
	}

	//---------------------------------------------------------------
	// Condition related
	//---------------------------------------------------------------

	public static String getGuard(ActivityEdge edge, boolean and) {
		if (edge.getGuard() != null) {
			String prefix = "";
			if (and) {
				prefix = ", condition = ";
			}
			if (isEL(edge.getGuard())) {
				String value = edge.getGuard().stringValue();
				if (value.startsWith("#{")) {
					return prefix + "\"" + value + "\"";
				} else {
					return prefix + "\"#{" + value + "}\"";
				}
			} else {
				return prefix + edge.getGuard().stringValue();
			}
		}
		return "";
	}

	protected static boolean isEL(ValueSpecification guard) {
		if (guard instanceof OpaqueExpression) {
			OpaqueExpression el = (OpaqueExpression) guard;
			EList list = el.getLanguages();
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				String element = (String) iter.next();
				if (element.toUpperCase().equals("EL")) {
					return true;
				}
			}
		}
		return false;
	}

	//---------------------------------------------------------------
	// Operation related
	//---------------------------------------------------------------

	public static Iterator<Interface> getServiceDependencies(Activity activity) {
		Set<Interface> list = new HashSet<Interface>();
		Iterator i = activity.getEdges().iterator();
		while (i.hasNext()) {
			ActivityEdge edge = (ActivityEdge) i.next();
			if (edge.getTarget() instanceof CallOperationAction) {
				CallOperationAction action = (CallOperationAction) edge
						.getTarget();
				if (action.getOperation() != null) {
					Interface service = action.getOperation().getInterface();
					ImportHelper.addImport(service, "Local");
					ImportHelper.addImport(service, "Bean");
					list.add(service);
				}
			}
		}
		return list.iterator();
	}
	
	public static Iterator<Operation> getServiceDependencies(AcceptEventAction event) {
		Set<Operation> list = new HashSet<Operation>();
		Iterator i = event.getOutgoings().iterator();
		while (i.hasNext()) {
			ActivityEdge edge = (ActivityEdge) i.next();
			if (edge.getTarget() instanceof CallOperationAction) {
				CallOperationAction action = (CallOperationAction) edge
						.getTarget();
				if (action.getOperation() != null) {
					Interface service = action.getOperation().getInterface();
					ImportHelper.addImport(service, "Local");
					ImportHelper.addImport(service, "Bean");
					list.add(action.getOperation());
				}
			} else {
				// TODO throw or message?
			}
		}
		return list.iterator();
	}


	public static Interface getService(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			return action.getOperation().getInterface();
		} else {
			return null;
		}
	}
	
	public static String getServiceName(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			ImportHelper.addImport(action.getOperation().getInterface());
			return action.getOperation().getInterface().getName();
		} else {
			return null;
		}
	}

	public static String getOperationName(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			return action.getOperation().getName();
		} else {
			return "ERROR_OPERATION_NOT_SPECIFIED";
		}
	}

	public static Operation getOperation(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			return action.getOperation();
		} else {
			return null;
		}
	}

	public static String getArguments(ActivityNode node) {
		Stereotype invoke = StereotypeHelper.getStereotype(node, "Invoke");
		EList<String> list = null;
		if (invoke != null) {
			list = (EList<String>) node.getValue(invoke, "arguments");
		}
		
		Operation operation = ((CallOperationAction) node).getOperation();
		StringBuffer result = new StringBuffer();
		for (Iterator iter = operation.getOwnedParameters().iterator(); iter
				.hasNext();) {
			Parameter parameter = (Parameter) iter.next();
			if (!parameter.getDirection().equals(
					ParameterDirectionKind.RETURN_LITERAL)) {
				if (result.length() > 0)
					result.append(", ");

				if (list != null && !list.isEmpty()) {
					result.append("@Arg(\"");
					result.append(list.get(operation.getOwnedParameters().indexOf(parameter)));
					result.append("\") ");
				}
				result.append(TypeHelper.getImportedType(parameter
						.getType()));
				result.append(' ');
				String paramName = parameter.getName();
				if (paramName != null && paramName.trim().length() == 0)
					paramName = null;
				result.append(paramName == null ? "arg"
						+ operation.getOwnedParameters().indexOf(parameter)
						: paramName);
			}
		}
		return result.toString();
		
	}

	public static String getRuntimeParameters(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			return InterfaceHelper.getParameters(action.getOperation(), false,
					false);
		} else {
			return null;
		}
	}

	public static String getOperationReturnType(ActivityNode node) {
		CallOperationAction action = (CallOperationAction) node;
		if (action.getOperation() != null) {
			return InterfaceHelper.getReturn(action.getOperation());
		} else {
			return null;
		}
	}

	//---------------------------------------------------------------
	// Task related
	//---------------------------------------------------------------

	private static final String TASK = "Task";

	public static class TaskDefinition {

		private ActivityNode node;
		private Stereotype stereotype;

		public TaskDefinition(ActivityNode node) {
			this.node = node;
			stereotype = StereotypeHelper.getStereotype(node, TASK);
		}

		public String name() {
			return node.getName();
		}

		public String description() {
			return formatNull((String) node.getValue(stereotype, "description"));
		}

		public String priority() {
			NamedElement e = (EnumerationLiteral) node.getValue(stereotype,
					"priority");
			if (e == null) {
				return "Priority.NORMAL";
			} else {
				return "Priority." + e.getName();
			}
		}

		public String user() {
			return formatNull((String) node.getValue(stereotype, "userId"));
		}

		public String role() {
			return formatName((Actor) node.getValue(stereotype, "role"));
		}

		public String group2() {
			return formatNull((String) node.getValue(stereotype, "group2"));
		}

		public String group3() {
			return formatNull((String) node.getValue(stereotype, "group3"));
		}

		public String escalationGroup() {
			String escalationRole = formatName((Actor) node.getValue(
					stereotype, "escalationRole"));
			if (escalationRole != null) {
				return "escalationGroup = \"" + escalationRole + "\", ";
			} else {
				if (hasDueDate() && !isTimeoutTransitionDefined()
						&& isEmpty(escalationRole)) {
					log("WARNING: "
							+ node.getQualifiedName()
							+ " has a due date but no timeout transition or escalation role. "
							+ "The escaltion role will default to TaskManager.");
					return "escalationGroup = \"TaskManager\", ";
				}
				return "";
			}
		}

		public String viewId() {
			return formatNull((String) node.getValue(stereotype, "viewId"));
		}

		public String hasTimeoutTransition() {
			if (isTimeoutTransitionDefined()) {
				return "hasTimeoutTransition = true, ";
			} else {
				return "";
			}
		}

		private boolean isTimeoutTransitionDefined() {
			EList<ActivityEdge> edges = node.getOutgoings();
			for (ActivityEdge activityEdge : edges) {
				if ("timeout".equalsIgnoreCase(activityEdge.getName())) {
					return true;
				}
			}
			return false;
		}

		public boolean hasDueDate() {
			// return !isEmpty(td.dueDateExpression) || (td.dueDateAmount != null &&
			// td.dueDateAmount != 0);
			return !"".equals(getDueDate());
		}

		public String getDueDate() {
			if (dueDateExpression() != null && dueDateAmount() != 0) {
				ImportHelper
						.getImportedName("net.taylor.bpm.annotations.Time.Unit");
				return "dueDate = @Time(value = \""+ dueDateExpression() +"\", amount = " + dueDateAmount()
						+ ", unit = " + dueDateUnit() + "), ";
			}
			if (dueDateExpression() != null) {
				return "dueDate = @Time(\"" + dueDateExpression() + "\"), ";
			}
			if (dueDateAmount() != 0) {
				ImportHelper
						.getImportedName("net.taylor.bpm.annotations.Time.Unit");
				return "dueDate = @Time(amount = " + dueDateAmount()
						+ ", unit = " + dueDateUnit() + "), ";
			}
			return "";

		}

		public String getReminderDate() {
			if (reminderExpression() == null) {
				return "";
			}
			if (reminderAmount() == 0) {
				return "";
			}
			ImportHelper
					.getImportedName("net.taylor.bpm.annotations.Time.Unit");
			return "reminder = @Time(value = \""+ reminderExpression() +"\", amount = " + reminderAmount()
					+ ", unit = " + reminderUnit() + "), ";

		}

		public String dueDateUnit() {
			return formatCalendarField((EnumerationLiteral) node.getValue(
					stereotype, "dueDateUnit"));
		}

		public Integer dueDateAmount() {
			return (Integer) node.getValue(stereotype, "dueDateAmount");
		}

		public String dueDateExpression() {
			return formatNull((String) node.getValue(stereotype,
					"dueDateExpression"));
		}

		public String reminderUnit() {
			return formatCalendarField((EnumerationLiteral) node.getValue(
					stereotype, "reminderUnit"));
		}

		public Integer reminderAmount() {
			return (Integer) node.getValue(stereotype, "reminderAmount");
		}

		public String reminderExpression() {
			return formatNull((String) node.getValue(stereotype,
					"reminderExpression"));
		}
	}

	public static TaskDefinition getTaskDef(ActivityNode node) {
		return new TaskDefinition(node);
//		if (!hasDueDate(td)
//				&& (isTimeoutTransitionDefined(node) || !isEmpty(td.escalationRole))) {
//			log("WARNING: "
//					+ node.getQualifiedName()
//					+ " does not have a due date but does have a timeout transition or escalation role.");
//		}
//		if (isTimeoutTransitionDefined(node) && !isEmpty(td.escalationRole)) {
//			log("WARNING: "
//					+ node.getQualifiedName()
//					+ " has both a timeout transition and an escalation role. The escaltion role will be ignored.");
//		}
	}

	private static String formatNull(String value) {
		if (value == null || value.length() == 0) {
			return null;
		}
		return value;
	}

	private static String formatName(NamedElement e) {
		if (e == null) {
			return null;
		} else {
			return e.getName();
		}
	}

	private static String formatCalendarField(NamedElement e) {
		if (e == null) {
			return "Unit.Days";
		} else {
			return "Unit." + e.getName();
		}
	}

	public static String getTaskOutcome(ActivityEdge edge) {
		String outcome = edge.getName();
		if (outcome == null || outcome.length() == 0) {
			outcome = "ERROR: NO TASK OUTCOME DEFINED. TRANSITIONS (i.e. outcomes) FROM A TASK STEP MUST HAVE A NAME.";
		}
		return outcome;
	}

	public static String getArtifact(ActivityEdge edge) {
		return getArtifact(edge, new ArrayList());
	}

	public static String getArtifact(ActivityEdge edge, List sources) {
		if (sources.contains(edge)) {
			return null;
		}
		sources.add(edge);
		ActivityNode source = edge.getSource();
		if (source == null) {
			return null;
		}
		if (isOperation(source)) {
			return getOperationReturnType(edge.getSource());
		} else {
			String artifact;
			List<ActivityEdge> incoming = source.getIncomings();
			for (ActivityEdge activityEdge : incoming) {
				artifact = getArtifact(activityEdge, sources);
				if (artifact != null) {
					return artifact;
				}
			}
			return null;
		}
	}

	//---------------------------------------------------------------
	// Fork/Join related
	//---------------------------------------------------------------

	public static String getForkName(ActivityEdge edge) {
		ActivityNode forked = getForked(edge);
		if (forked != null) {
			if (forked instanceof CallOperationAction) {
				CallOperationAction op = (CallOperationAction) forked;
				String methodName = getOperationName(op);
				return "\"" + methodName + "\"";
			} else {
				// TODO more options?
				return "\"" + forked.getName() + "\"";
			}
		}
		return "NOT_FOUND";
	}

	protected static ActivityNode getForked(ActivityEdge edge) {
		if (edge.getTarget() instanceof ForkNode) {
			return edge.getSource();
		} else if (edge.getTarget() instanceof JoinNode) {
			// get all the transitions to the join
			Iterator i = edge.getTarget().getIncomings().iterator();
			while (i.hasNext()) {
				ActivityEdge e = (ActivityEdge) i.next();
				// step back one
				Iterator j = e.getSource().getIncomings().iterator();
				if (j.hasNext()) {
					ActivityNode n = getForked((ActivityEdge) j.next());
					if (n != null) {
						// the first will do
						return n;
					}
				}
			}
			return null;
		} else if (edge.getSource() instanceof ForkNode) {
			Iterator i = edge.getSource().getIncomings().iterator();
			if (i.hasNext()) {
				ActivityEdge e = (ActivityEdge) i.next();
				return (ActivityNode) e.getSource();
			} else {
				return null;
			}
		} else {
			Iterator i = edge.getSource().getIncomings().iterator();
			if (i.hasNext()) {
				ActivityEdge e = (ActivityEdge) i.next();
				return getForked(e);
			} else {
				return null;
			}
		}
	}

	public static String getJoinCount(ActivityNode node) {
		return String.valueOf(node.getIncomings().size());
	}

	//---------------------------------------------------------------
	// Timer related
	//---------------------------------------------------------------
	
	public static String getTime(ActivityEdge edge) {
		ActivityNode target = edge.getTarget();
		Stereotype s = StereotypeHelper.getStereotype(target, "Timer");
		Integer amount = (Integer) target.getValue(s, "amount");
		String expression = (String) target.getValue(s, "expression");
		String field = formatCalendarField((EnumerationLiteral) target
				.getValue(s, "field"));

		if (expression != null && expression.length() > 0) {
			ImportHelper.getImportedName("java.util.Date");
			return "expiration = @Time(\"" + expression + "\")";
		} else {
			ImportHelper.getImportedName("net.taylor.bpm.annotations.Time.Unit");
			return "expiration = @Time(amount = " + amount + ", unit = " + field + ")";
		}
	}

	public static String getCron(AcceptEventAction node) {
		return StereotypeHelper.getValue(node, "Scheduled", "cron").toString();
	}

	//---------------------------------------------------------------
	// Testing related
	//---------------------------------------------------------------

	public static String getTriggerServiceName(Activity activity) {
		Iterator i = activity.getNodes().iterator();
		while (i.hasNext()) {
			ActivityNode node = (ActivityNode) i.next();
			if (isOperation(node) && isTrigger(node)) {
				return getServiceName(node);
			}
		}
		return null;
	}

	public static String getTriggerOperationName(Activity activity) {
		Iterator i = activity.getNodes().iterator();
		while (i.hasNext()) {
			ActivityNode node = (ActivityNode) i.next();
			if (isOperation(node) && isTrigger(node)) {
				return getOperationName(node);
			}
		}
		return null;
	}

	public static ActivityNode getTriggerNode(Activity activity) {
		Iterator i = activity.getNodes().iterator();
		while (i.hasNext()) {
			ActivityNode node = (ActivityNode) i.next();
			if (isOperation(node) && isTrigger(node)) {
				return node;
			}
		}
		return null;
	}

	public static String getTriggerArguments(Activity activity) {
		Iterator i = activity.getNodes().iterator();
		while (i.hasNext()) {
			ActivityNode node = (ActivityNode) i.next();
			if (isOperation(node) && isTrigger(node)) {
				Operation operation = getOperation(node);
				String type = InterfaceHelper.getFirstParameterType(operation);
				return type + " arg = new " + type + "();"; 
			}
		}
		return "// TODO trigger args";
	}
	
	public static List<List<ActivityEdge>> getFlows(Activity activity) {
		List<List<ActivityEdge>> flows = new ArrayList<List<ActivityEdge>>();
		List<ActivityEdge> flow = new ArrayList<ActivityEdge>();
		flows.add(flow);
		ActivityNode trigger = getTriggerNode(activity);
		getFlows(trigger, flows, flow);		
		return flows;
	}
	
	protected static void getFlows(ActivityNode node, List<List<ActivityEdge>> flows, List<ActivityEdge> flow) {
//		if (node == null) return;
		
		List<ActivityEdge> uptohere = new ArrayList<ActivityEdge>();
		uptohere.addAll(flow);
		
		List<ActivityEdge> outgoing = node.getOutgoings();
		boolean first = true;
		for (ActivityEdge edge : outgoing) {
			if (flow.contains(edge)) {
				flow.add(edge);
				continue;
			}
			ActivityNode target = edge.getTarget();
			if (first) { // default path
				first = false;
				flow.add(edge);
				getFlows(target, flows, flow);		
			} else {
				List<ActivityEdge> newflow = new ArrayList<ActivityEdge>();
				newflow.addAll(uptohere);
				newflow.add(edge);
				flows.add(newflow);
				getFlows(target, flows, newflow);		
			}
		}
	}
	
	// TODO list of list of all flows
	// outcomes and guards
	// get trigger
	// for each outcome
	// recurse on target
	// stop when target already exists or final or no outcome
	// for outgoing > 0 start new list
	
	public static Iterator<ActivityNode> getBasicFlow(Activity activity) {
		List<ActivityNode> list = new ArrayList<ActivityNode>();
		ActivityNode trigger = getTriggerNode(activity);
		ActivityNode next = getNext(trigger);
		while (next != null) {
			list.add(next);
			next = getNext(next);
		}
		return list.iterator();
	}
	
	protected static ActivityNode getNext(ActivityNode source) {
		if (source == null) {
			return null;
		}
		if (source.getOutgoings().size() == 0) {
			return null;
		}
		ActivityNode target = source.getOutgoings().get(0).getTarget();
		if (isFlowFinalNode(target)) {
			return null;
		}
		return target;
	}
	
	public static String getDefaultOutcome(ActivityNode node) {
		if (node.getOutgoings().size() == 0) {
			return "NO TRANSITION DEFINED";
		}
		String outcome = node.getOutgoings().get(0).getName();
		if (outcome == null || outcome.length() == 0) {
			return "NO TRANSITION DEFINED";
		}
		return outcome.toUpperCase() + "_OUTCOME";
	}
	
	//---------------------------------------------------------------
	// utils
	//---------------------------------------------------------------

	private static void log(String msg) {
		try {
			MessageConsoleStream stream = Console.getStream();
			if (stream != null) {
				stream.println(msg);
			}
		} catch (Exception e) {			
		}
		GeneratorPlugin plugin = GeneratorPlugin.getDefault();
		if (plugin != null) {
			plugin.log(msg);
		}
	}

	private static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}
}
