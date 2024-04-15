 public Command dropMutliDependency(Dependency dependency, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) { CompoundCommand command = new CompoundCommand();  // 0. Obtain list of property to display  ArrayList<NamedElement> endToDisplaySource = new ArrayList<NamedElement>(dependency.getClients());  ArrayList<NamedElement> endToDisplayTarget = new ArrayList<NamedElement>(dependency.getSuppliers());  // 1. creation of the diamond of the Dependency  DependencyDiamonViewCreateCommand nodeCreation = new DependencyDiamonViewCreateCommand(getEditingDomain(), containerView, viewer, diagramPreferencesHint, location, new SemanticAdapter(dependency, null));  command.add(new ICommandProxy(nodeCreation)); } 
