 		for (ASTNode node : this.elements) {			node.traverseTopDown(visitor); 		} 		if (arrayDereferenceList != null) { 			arrayDereferenceList.traverseTopDown(visitor); 		} 	}
