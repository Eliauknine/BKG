 public void removeConflictResolver(CDOConflictResolver resolver){  if (changed)      {  resolver.setTransaction(null);  fireEvent(new ConflictResolversEventImpl());       }     } 
