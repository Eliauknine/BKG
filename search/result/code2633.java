  else if (userAgent.indexOf("Mobile") != -1) { // iPad reports this in fullscreen mode  info = new BrowserInfo(BrowserInfo.Type.APPLE_SAFARI, v);       }  else {  info = new BrowserInfo(BrowserInfo.Type.UNKNOWN, null); } }
