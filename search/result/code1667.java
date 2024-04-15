 		if (!detect) { 			return null; 		} 		return new IScriptCompletionProposal[] { new RunCommandProposal(), new RemoveImportProposal(context) }; 	}
