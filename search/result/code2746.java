 public String toString()  {  String name = repositoryInfo == null ? "?" : repositoryInfo.getName();   return MessageFormat.format("Session{0} [{1}]", sessionID, name);    } 
