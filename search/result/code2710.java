  final Label label = new Label(titleComposite, SWT.NONE);  label.setBackground(parent.getBackground());  label.setText(getItemPropertyDescriptor().getDisplayName(null));  GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(label);  // VALIDATION }
