 public CDOView createView(CDORevisionProvider revisionProvider){  try       {  return authorize(revision, revisionProvider, securityContext, session, null, null);       }  finally       { } } 
