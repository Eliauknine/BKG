 protected SearchResult computeInstalled(IProgressMonitor monitor) throws CoreExc{  Set<INode> catalogNodes = marketplaceInfo.computeInstalledNodes(catalogDescriptor.getUrl(), installedIUs);  if (!catalogNodes.isEmpty()) {  List<INode> resolvedNodes = marketplaceService.getNodes(catalogNodes, progress.newChild(490));  SubMonitor nodeProgress = SubMonitor.convert(progress.newChild(10), resolvedNodes.size());  for (INode node : resolvedNodes) {  //compute real installed state based on optional/required state  if (marketplaceInfo.computeInstalled(installedIUs.keySet(), node)) {  result.getNodes().add((Node) node); 					}  nodeProgress.worked(1); } } } 
