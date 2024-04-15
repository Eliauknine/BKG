	@Override	public boolean endvisit(ModuleDeclaration s) throws Exception { 		boolean res = super.endvisit(s); 		if (!hasNamespace) { 			checkUnusedImport(); 		} } 
