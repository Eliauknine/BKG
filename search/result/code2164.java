  dialog.setInput(dialogRoot);  if (dialog.open() == Window.OK)  setResult("workspace:/" + ((IPath) dialog.getFirstResult()).toPortableString()); 					}
