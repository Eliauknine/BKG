 private ServiceTracker logServiceTracker = null;  public static void log(String message) {  getDefault().log(new Status(IStatus.OK, PLUGIN_ID, IStatus.OK, message, null)); 	} 
