 public static boolean isResourceTreeImpacted(CommitImpactContext context)  {  InternalCDORevisionDelta[] revisionDeltas = (InternalCDORevisionDelta[])context.getDirtyObjectDeltas();    for (int i = 0; i < revisionDeltas.length; i++)     {  InternalCDORevisionDelta revisionDelta = revisionDeltas[i];    // Any tree move might impact this permission  CDOFeatureDelta containerDelta = revisionDelta.getFeatureDelta(CDOContainerFeatureDelta.CONTAINER_FEATURE);  if (containerDelta != null)       {  return true;       }    // Any change of resource node name might impact this permission  CDOFeatureDelta nameDelta = revisionDelta.getFeatureDelta(EresourcePackage.Literals.CDO_RESOURCE_NODE__NAME);  if (nameDelta != null)       {  return true;       }     }    return false;   } 
