 @SuppressWarnings("null") @Inject  public void setX(@Named(UIEvents.Window.X) int _x) {  if( ! isPropertyChangeInProgress(UIEvents.Window.X) ) {  int x = _x;  if (x == -2147483648) {  x = 0; } } } 
