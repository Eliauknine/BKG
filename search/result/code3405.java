 protected IScriptCompletionProposal createKeywordProposal({  protected IScriptCompletionProposal createScriptCompletionProposal(  CompletionProposal proposal) {  ScriptCompletionProposal completionProposal = (ScriptCompletionProposal) super 				.createScriptCompletionProposal(proposal);  if (proposal.getKind() == CompletionProposal.METHOD_DECLARATION) {  IMethod method = (IMethod) proposal.getModelElement();  try { } } } } 
