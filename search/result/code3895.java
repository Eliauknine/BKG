 public void runInSWTThread(Runnable runnable) { if (Display.getCurrent() == null) {  Display.getDefault().asyncExec(runnable); 		} else {  runnable.run(); 		} 	} 
