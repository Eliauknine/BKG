 return new ISearchResult() { public List<? extends INode> getNodes() {  return nodes; 			}  public Integer getMatchCount() {  return nodes.size(); 			} 		}; 	
