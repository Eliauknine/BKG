 else if (location instanceof IFile){  handle = new ResourceHandle((IFile) location, mode); else if (location != null)  handle = getFileHandle(  ResourceTools.resolveFile(location, getScriptEngine().getExecutedFile(), mode == IFileHandle.READ),  mode);  if ((handle != null) && (!handle.exists())) {  // create file if it does not exist yet } } 
