  dialog.setTitle(title); dialog.setMessage(message);  dialog.setInput(dialogRoot);  if (dialog.open() == Window.OK)  setResult("workspace:/" + ((IResource) dialog.getFirstResult()).getFullPath().toPortableString()); }
