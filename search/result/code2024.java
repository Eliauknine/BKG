 @SuppressWarnings("null") @Inject  public void setWidth(@Named(UIEvents.Window.WIDTH) int w) {  if( ! isPropertyChangeInProgress(UIEvents.Window.WIDTH) ) {  getWidget().setWidth(w); 			} 		} 
