 public CDOID provideCDOID(Object idObject)  {  CDOID id = (CDOID)idObject;  if (disableLegacyObjects || id.isNull() || id.isMeta())     {  return id;     } } 
