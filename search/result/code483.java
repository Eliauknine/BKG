 private void createFBTypesOfCFB(final FBType fbType, final Resource res) throws{  if(!getTypes().contains(netelem.getTypeName())) { Map<String, AdapterType> adapters = getAdapterTypes(netelem.getInterface());						  if(!adapters.isEmpty()) {  loopAdapterTypes(adapters, res); 				}  createFBType((FBType) netelem.getType(), res); 			} } 
