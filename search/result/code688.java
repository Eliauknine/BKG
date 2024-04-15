 return isRelevanceOverriden ? relevanceOverride : super.getRelevance();	}  public void setRelevance(int value) {  this.relevanceOverride = value;  this.isRelevanceOverriden = true; 
