	@Override	public boolean visit(TypeDeclaration s) throws Exception { 		checkDuplicateDeclaration(s); 		return super.visit(s); 	} 
