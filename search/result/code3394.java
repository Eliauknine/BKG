  upEvent.widget = widget; upEvent.button = 1;  upEvent.type = SWT.MouseUp;  display.post(upEvent);  if (focus) {  widget.notifyListeners(SWT.FocusIn, upEvent); } }
