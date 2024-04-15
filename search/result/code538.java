  editors.forEach(editorPart -> editorPart.doSave(monitor)); getCommandStack().markSaveLocation();  AbstractTypeExporter.saveType(paletteEntry);  firePropertyChange(IEditorPart.PROP_DIRTY); 			}
