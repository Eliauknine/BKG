  @Override  protected EditingDomain doGetEditingDomain() {  EditingDomain result = checkSessions();  if (result == null)  showNoEditingDomainWarning();  return result;   } }
