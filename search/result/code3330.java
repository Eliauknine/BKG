 public void run(){       { try         {  boolean result = MessageDialog.openQuestion(getShell(), "Change perspective",  "Do you want to switch to CDO Explorer perspective?");  if (result)           {  workbench.showPerspective(CDOExplorerPerspective.ID, workbench.getActiveWorkbenchWindow()); } } } } 
