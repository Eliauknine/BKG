 		for (ASTNode node : this.elements) {			node.accept(visitor); 		} 		if (arrayDereferenceList != null) { 			arrayDereferenceList.accept(visitor); 		} 	}
