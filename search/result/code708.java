 				container.run(true, true, pm -> {					pm.beginTask(PHPUnitMessages.PHPUnitSearchEngine_Searching, IProgressMonitor.UNKNOWN); 					List<IType> elements = searchEngine.findPHPUnitClassesByTestSuite(scriptProject, true, false,  new SubProgressMonitor(pm, IProgressMonitor.UNKNOWN)); 					if (pm.isCanceled()) { 						return; 					} } }
