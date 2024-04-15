  EcoreHelper.registerEcore(ecorePath);	}  /** 	 * @param view 	 */  private void saveChangedView(VView view) {  try {  view.eResource().save(null); } }
