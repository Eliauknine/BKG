  ErrorResult resultobj = aFactory.createErrorResult();  resultobj.setErrorByTimeStep(list);  result = result/(double)time.length;  resultobj.setError(result);  return resultobj;	 }
