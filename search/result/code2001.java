 @Override  public void run() {  final ContainerSelectionDialog dialog = new ContainerSelectionDialog(Display.getDefault() 							.getActiveShell(), dialogRoot, true, message);  dialog.setTitle(title);  if (dialog.open() == Window.OK) } 
