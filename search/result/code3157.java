 public static void displayStatus(Shell shell, final String title, final IStatus{  String message = status.getMessage();  if (showLinkToErrorLog) {  message += "  \n see error log";         } } 
