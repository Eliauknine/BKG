 protected Control renderControl(SWTGridCell cell, Composite parent) throws NoRen{  final Composite controlComposite = new Composite(composite, SWT.NONE);  GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL)   .hint(1, 300)   .applyTo(controlComposite);  GridLayoutFactory.fillDefaults().numColumns(1).applyTo(controlComposite);  createContent(controlComposite, mainSetting); } 
