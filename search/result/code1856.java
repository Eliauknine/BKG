	public void handleMultipleBindingError() { 		final int port = getReceiverPort(); 		Logger.log(Logger.ERROR, "Could not open broadcast port on: " + port  				+ " (port might be in use). Select different port number");  		final Display display = Display.getDefault(); 		display.asyncExec(new Runnable() { 			public void run() { 				final String message = MessageFormat.format( 						Messages.BroadcastDaemon_Broadcast_port_is_already_in_use, 						String.valueOf(port)); 				MessageDialog.openWarning(display.getActiveShell(), 						Messages.BroadcastDaemon_ZD_port_problem, message); 			} 		}); 	} 
