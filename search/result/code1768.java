 				} else {					return new ICompletionStrategy[] {}; 				} 			} else { 				return new ICompletionStrategy[] { new ClassKeywordsStrategy(context), 						new GlobalConstantsStrategy(context), 						// new GlobalTypesStrategy(context) 				}
