  if (request == null) { return; 		} else {  reqState.setCurrentRequest(null); 		}  // No data refresh actions for cancelled requests.  if (request.isCancelled() || request.isFailed()) {  requestStateUpdate();  if (TraceDebug.isDEBUG()) {  TmfTimeRange trange = request.getRange();  if (request.isCancelled()) { } } } }
