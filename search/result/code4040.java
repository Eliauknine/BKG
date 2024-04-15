 public void execute(IProgressMonitor monitor){  savedResources.add(resource); resource.save(saveOptions);             }  catch (Exception exception)             {  OM.LOG.error(exception); } 
