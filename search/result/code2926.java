 public void update(Observable o, Object arg) {  if((decorationService != null) && (o == decorationService)) {  fireLabelProviderChanged(new LabelProviderChangedEvent(this)); 		} 	}  @Override 
