 		int rightNonWhitespaceChar = lineText.length() - 1;		final byte[] bytes = lineText.getBytes(); 		boolean keepSearching = true;   		while (keepSearching) { 			final boolean leftIsWhiteSpace = bytes[leftNonWhitespaceChar] == CHAR_SPACE || bytes[leftNonWhitespaceChar] == CHAR_TAB;  			final boolean rightIsWhiteSpace = bytes[rightNonWhitespaceChar] == CHAR_SPACE || bytes[rightNonWhitespaceChar] == CHAR_TAB; 			if (leftIsWhiteSpace) leftNonWhitespaceChar++; 			if (rightIsWhiteSpace) rightNonWhitespaceChar--; 			keepSearching = (leftIsWhiteSpace || rightIsWhiteSpace) && (leftNonWhitespaceChar < rightNonWhitespaceChar) ; 		}   		// if line is empty then the indexes were switched 		if (leftNonWhitespaceChar > rightNonWhitespaceChar)  			return new SimpleStructuredRegion(lineInfo.getOffset() , 0);    		// if there are no changes - return the original line information, else build fixed region 		return leftNonWhitespaceChar == 0 && rightNonWhitespaceChar == lineText.length() - 1 ?  			lineInfo :   			new SimpleStructuredRegion(lineInfo.getOffset() + leftNonWhitespaceChar, rightNonWhitespaceChar - leftNonWhitespaceChar + 1);  	}
