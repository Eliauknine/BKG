 					} else { // open select file dialog  final ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(Display.getDefault()  .getActiveShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());  dialog.setTitle(title);  dialog.setMessage(message);  dialog.setInput(dialogRoot);  if (dialog.open() == Window.OK)  setResult("workspace:/" 									+ ((IResource) dialog.getFirstResult()).getFullPath().toPortableString()); 					}
