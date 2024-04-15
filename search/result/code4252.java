 public void fatalError(SAXParseException e) {  System.out.println("Fatal error: line " + e.getLineNumber() + ":" + e.getColumnNumber() + ": " + e.getMessage());  System.exit(1); 	} 
