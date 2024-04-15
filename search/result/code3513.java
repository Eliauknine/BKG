  } @Override  public void cancel(RuntimeException cancelException)   {  if (timeoutTask != null)     {  timeoutTask.cancel();  timeoutTask = null;     }  super.cancel(cancelException);   
