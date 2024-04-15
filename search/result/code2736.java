 protected void clearUserInfos(){   { synchronized (userInfos)     {  userInfos.clear();  permissionBag.clear();  permissionArray = null; } } } 
