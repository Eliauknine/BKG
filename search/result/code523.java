 			int start = problem.getOffset();			int end = problem.getOffset() + problem.getLength(); 			String nodeName = cu.getSource().substring(start, end); 			node = new Identifier(start, end, context.getASTRoot().getAST(), nodeName); 			node.setParent(selectedNode, Comment.COMMENT_TYPE_PROPERTY); 			selectedNode = node; 		} else { }
