  PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IIDEHelpContextIds.RESOURCE_FILTER_PROPERTY_PAGE);  IContainer resource = (IContainer) getElement().getAdapter(  IContainer.class);  if (resource == null) {  IProject project = (IProject) getElement().getAdapter(  IProject.class);  if (project != null)  resource = project; 		}  groupWidget.setContainer(resource);  return groupWidget.createContents(parent); 	}
