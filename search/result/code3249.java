 public void performQuery(Market market, Category category, String queryText, IPr{  SearchResult result = marketplaceService.search(market, category, queryText, new SubProgressMonitor(  monitor, totalWork / 2));  handleSearchResult(catalogCategory, result, new SubProgressMonitor(monitor, totalWork / 2)); 		} finally {  monitor.done(); 		} 
