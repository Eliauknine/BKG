  super.widgetSelected(e); final ColorDialog cd = new ColorDialog(parent.getShell());  final RGB rgb = cd.open();  setValue(getString(rgb)); 			}
