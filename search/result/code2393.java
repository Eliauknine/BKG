 		for (ASTNode node : this.elements) {			node.traverseBottomUp(visitor); 		} 		if (arrayDereferenceList != null) { 			arrayDereferenceList.traverseBottomUp(visitor); 		} 		accept(visitor); 	}
