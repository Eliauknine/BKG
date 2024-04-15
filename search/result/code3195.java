 public static boolean isValidTimeStamp(long timeStamp, long startTime, long endTime)   {  return (endTime == CDOBranchPoint.UNSPECIFIED_DATE || endTime >= timeStamp) && timeStamp >= startTime;   } 
