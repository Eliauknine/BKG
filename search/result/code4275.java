 	}  private void processParseError(boolean parseError) {  modelChangeController.setHoldState(parseError ? PARSE_ERROR_STATE : ModelChangeController.READY_STATE, null); 		((ReloadAction) graphicalActionRegistry.getAction(ReloadAction.RELOAD_ACTION_ID)).parseError(parseError); 	}
