	 */ public static synchronized void clearRegistry() {  STORAGE.clear();  composedAdapterFactory.dispose();  composedAdapterFactory = null; 	} 
