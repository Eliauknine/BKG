 public void putUpdate(InputStream stream,{  // Update the file contents.  writeToFile(stream, file);    // Update config graph with new content type.  Resource associatedResource = associatedModel.getResource(associatedURI);  associatedResource.removeAll(DCTerms.format); } 
