  upEvent.type = SWT.MouseUp; upEvent.x = size.x / 2;  upEvent.y = size.y / 2;  display.post(upEvent);  button.setSelection(selection);  button.notifyListeners(SWT.Selection, upEvent); }
