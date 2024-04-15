 	 * 	 */  protected void applyEnable() {  for (final GridCell gridCell : controls.keySet()) {  setControlEnabled(gridCell, controls.get(gridCell), getVElement().isEnabled()); 		} 	}  /** 	 * Wraps the call to enable/disable control. 	 *  	 * @param gridCell the {@link GridCell} to enable/disable 	 * @param control the {@link Control} to enable/disable 	 * @param enabled true if control should be enabled, false otherwise 	 * @since 1.3 	 */  protected void setControlEnabled(GridCell gridCell, Control control, boolean enabled) {  control.setEnabled(enabled); 	} }
