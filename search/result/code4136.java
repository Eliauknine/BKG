		}	}  public static void removeMetadataRepository(IProvisioningAgent agent, URI location) {  IMetadataRepositoryManager manager = (IMetadataRepositoryManager) agent.getService(IMetadataRepositoryManager.SERVICE_NAME);  if (manager == null)  throw new IllegalStateException("No metadata repository manager found");  manager.removeRepository(location); 	
