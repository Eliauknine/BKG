	 */ public void contributeToMenu(IMenuManager menu) {  super.contributeToMenu(menu);  IMenuManager gotoMenu = menu.findMenuUsingPath("navigate/goTo");   menu.findMenuUsingPath("source");   if (gotoMenu != null) { } } 
