	 * @throws CoreException	 */  @Override  public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {  if (!(data instanceof Hashtable)) {  return; 		}  @SuppressWarnings("rawtypes")  Hashtable map = (Hashtable) data;  try {  isDuplicateDiagramAllowed = Boolean.parseBoolean((String) map.get(IS_DUPLICATE_EDITOR_ALLOWED_PARAMETER)); 		} catch (Exception e) {  // silently fail; 		} 	} 
