 entityPart = StringUtility.replaceTags(entityPart, "whereParts", new ITagProcessor() { @Override  public String processTag(String tagName, String tagContent) {  return " AND " + s;//legacy: always prefix an additional AND           }         });       
