 			IModelElement enclosingElement = getEnclosingElement(); 			while (enclosingElement instanceof IMethod) { 				enclosingElement = enclosingElement.getParent(); 			} 			if (enclosingElement instanceof IType && PHPFlags.isAnonymous(((IType) enclosingElement).getFlags())) { 				tmpTypes.add((IType) enclosingElement); } }
