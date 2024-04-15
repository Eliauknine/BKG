 return false;  }  public boolean isHttpLink(String link) {  if ((StringUtility.find(link, "http://") >= 0) || (StringUtility.find(link, "https://") >= 0)) {  return true;     } 
