 @SuppressWarnings("null") @Inject  public void setY(@Named(UIEvents.Window.Y) int _y) {  if( ! isPropertyChangeInProgress(UIEvents.Window.Y) ) {  int y = _y;  if (y == -2147483648) {  y = 0; } } } 
