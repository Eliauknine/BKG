 			// "use X\Y\ { A, B, \C\D| };" with '|' the cursor position.			// When found, at this point statementText will contain "A, B, \C\D" 			// and statementTextBeforeCurly will contain "use X\Y\ ". 			TextSequence statementTextBeforeOpeningCurly = PHPTextSequenceUtilities 					.getStatement(foundDelimiter[0].getStart(), sdRegion, true); 			if (hasUsePrefix(statementTextBeforeOpeningCurly)) { } }
