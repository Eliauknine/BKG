	 * @return ContentGeneratorDescriptor or <code>null</code>.	 */  public ContentGeneratorDescriptor getContentGenDescriptor (String id) {  if (id != null && generators.containsKey(id)) {  return generators.get(id); 		}  return null; } 
