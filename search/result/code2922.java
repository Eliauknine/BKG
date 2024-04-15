  filterWidget = new SyncFilterWidget(composite, SWT.NONE); filterWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));  filterWidget.setFilter(filter);  update();  return composite; }
