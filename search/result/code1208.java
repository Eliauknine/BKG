 public void init(final IEditorSite site, final IEditorInput input){ 			 */ this.resourceSet = new ResourceSetImpl(); 		}  final AdapterFactory adapterFactory = new AdapterFactoryImpl();  final CommandStack commandStack = new BasicCommandStack();  this.editingDomain = new AdapterFactoryEditingDomain(adapterFactory,  commandStack, this.resourceSet);  this.facetSetShortcuts = TreeEditorShortcutUtils.getFacetSetShortcuts(this.resourceSet);  this.customShortcuts = TreeEditorShortcutUtils.getCustomShortcuts(this.resourceSet); 	} 
