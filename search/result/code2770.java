 private Object protectableObject;  public NoPermissionException(Object protectableObject)   {  this(protectableObject, "No permission to access " + protectableObject);   }  public NoPermissionException(Object protectableObject, String message) 
