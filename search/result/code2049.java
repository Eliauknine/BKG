  return;				}  IObservableValue observableValue;  try {  observableValue = getEMFFormsDatabinding() 						.getObservableValue(getVElement().getDomainModelReference(),  getViewModelContext().getDomainModel()); 				} catch (final DatabindingFailedException ex) {  getReportService().report(new DatabindingFailedReport(ex));  return; }
