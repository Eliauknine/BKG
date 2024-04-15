 public IFileHandle writeLine(final Object location, final String data, @ScriptPa{  if (handle != null)  handle.write(data + LINE_DELIMITER);  return handle; 	} 
