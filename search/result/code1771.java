 				enclosingElement = enclosingElement.getParent();			} 			if (enclosingElement instanceof IType && !PHPFlags.isNamespace(((IType) enclosingElement).getFlags())) { 				return true; 			} 		}
