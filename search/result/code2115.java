	} /** 	 * Logs an exception. 	 * 	 * @param e the exception 	 */  public static void log(Exception e) {  activator.getLog().log(  new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e)); 	
