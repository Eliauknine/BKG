 	 */ private String getPrefix(String addr) {  String prefix = addr.split("//")[0];  return prefix.replace(":", ""); 	} }
