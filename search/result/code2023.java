 @SuppressWarnings("null") @Inject  public void setHeight(@Named(UIEvents.Window.HEIGHT) int h) {  if( ! isPropertyChangeInProgress(UIEvents.Window.HEIGHT) ) {  getWidget().setHeight(h); 			} 		} 
