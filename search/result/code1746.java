 	 */	protected void configureShell(Shell shell) { 		super.configureShell(shell); 		shell.setText("");  		PlatformUI.getWorkbench().getHelpSystem() 				.setHelp(shell, IIDEHelpContextIds.SAVE_AS_DIALOG); 	} }
