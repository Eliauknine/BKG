 public ImageRunSelectionModel( final IDockerConnection selectedConnection) {  refreshConnectionNames();  setSelectedConnectionName(selectedConnection.getName());  refreshImageNames(); 	} 
