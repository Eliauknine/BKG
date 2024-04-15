 public void setAutoReleaseLocksEnabled(boolean on){  if (autoReleaseLocksEnabled != on)      {  autoReleaseLocksEnabled = on;  fireEvent(new AutoReleaseLockEventImpl());       }     } 
