 public void detach(CDOResourceImpl cdoResource)  {  CDOStateMachine.INSTANCE.detach(cdoResource);  fireEvent(new ResourcesEvent(cdoResource.getPath(), ResourcesEvent.Kind.REMOVED));   }  /** 
