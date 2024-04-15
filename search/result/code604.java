 		} 		if (builder.length() > 0) { 			HTMLPrinter.insertPageProlog(builder, 0, getStyleSheet()); 			HTMLPrinter.addPageEpilog(builder); 			return new StringReader(builder.toString()); }
