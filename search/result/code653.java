 private void postProcessContentGenerators(Map<String, Collection<IConfigurationE{  private void processGroupingEntries(Map<String, Collection<MarkerGroupingEntry>> groupingEntries) { for (Entry<String, Collection<MarkerGroupingEntry>> entry : groupingEntries.entrySet()) {  String nextGroupId = entry.getKey();  if (markerGroups.containsKey(nextGroupId)) {   MarkerGroup group = markerGroups.get(nextGroupId);  for (MarkerGroupingEntry markerGroupingEntry : entry.getValue()) {  markerGroupingEntry.setGroup(group); 				} } } } } 
