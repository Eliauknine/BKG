 @Override public ShowInContext getShowInContext() {  IMarker[] markers = getSelectedMarkers();  return new ShowInContext(new StructuredSelection(retrieveModelObjects(markers)), new StructuredSelection(  retrieveResources(markers))); 				} 			
