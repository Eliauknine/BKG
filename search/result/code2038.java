  final Collection<IShellDropHandler> listeners = getDropTargetListeners(); if (!listeners.isEmpty()) {  // 1st pass: try to unpack dropped element and pass it to drop handler  for (final IShellDropHandler listener : listeners) {  if (listener.accepts(fScriptEngineProvider.getScriptEngine(), element)) {  listener.performDrop(fScriptEngineProvider.getScriptEngine(), element);  return; 				} 			}  // 2nd pass: no listener found for unwrapped object, try with original object  for (final IShellDropHandler listener : listeners) {  if (listener.accepts(fScriptEngineProvider.getScriptEngine(), event.data)) {  listener.performDrop(fScriptEngineProvider.getScriptEngine(), event.data);  return; 				} 			} 		} }
