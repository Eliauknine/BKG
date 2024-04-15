 new Runnable() { public void run() {  fRegisterGroups.add( new CRegisterGroup( getDebugTarget(), name, descriptors ) );  getDebugTarget().fireChangeEvent( DebugEvent.CONTENT ); 				} 			} ); 
