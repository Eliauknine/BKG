 		ClassInstanceCreation o = (ClassInstanceCreation) other;		return (safeSubtreeMatch(node.getClassName(), o.getClassName()) 				&& safeSubtreeListMatch(node.ctorParams(), o.ctorParams())); 	}
