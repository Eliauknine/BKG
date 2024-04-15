 public void addConflictResolver(CDOConflictResolver resolver){  if (changed)       {  fireEvent(new ConflictResolversEventImpl());       }     } 
