	 * @return MarkerGroupingEntry	 */  public MarkerGroupingEntry findGroupValue(String type, IMarker marker) {  if (typesToMappings.containsKey(type)) {  EntryMapping defaultMapping = null;  Iterator<EntryMapping> mappings = typesToMappings.get(type).iterator();  while (mappings.hasNext()) {  EntryMapping mapping = mappings.next();  if (mapping.hasAttributes()) { } } } } 
