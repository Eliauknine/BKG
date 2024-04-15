  _changeListeners = new HashSet<IPropertyChangeListener>(1); _input = null;  _lastCommandBeforeSave = null;  setupUndoRedo();  _control = createControls(parent_p);  hookControl(_control); }
