  clonedDescriptor.getInheritancePolicy().setDescriptor(clonedDescriptor);        }  // The returning policy  if (clonedDescriptor.hasReturningPolicy()) {  clonedDescriptor.setReturningPolicy((ReturningPolicy)getReturningPolicy().clone()); }
