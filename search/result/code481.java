 		}	}  private static void createFBNetwork(Resource res, XMLResource xmlResource) {  for (EObject object : xmlResource.getContents()) {  if(object instanceof Response) {  int i = 0;  for(org.eclipse.fordiac.ide.deployment.devResponse.FB fbresult : ((Response)object).getFblist().getFbs()) {								  //this version assumes that all fb types are available within the ide  FBTypePaletteEntry entry = (FBTypePaletteEntry) res.getDevice().getAutomationSystem().getPalette().getTypeEntry(fbresult.getType());  FBCreateCommand fbcmd = new FBCreateCommand(entry, res.getFBNetwork(), 100 * i, 10);  if(fbcmd.canExecute()) {  fbcmd.execute(); } } } }
