  IConfigurationElement[] elements = registry.getConfigurationElementsFor(NEW_CONNECTION_WIZARD_DELEGATE_EXTENSION_POINT_ID); for (int i = 0; i < elements.length; i++) {  IConfigurationElement element = elements[0];  if (element.getName().equals(NEW_CONNECTION_WIZARD_DELEGATE_EXTENSION_CONFIG_NAME)) {  String systemTypeID = element.getAttribute(NEW_CONNECTION_WIZARD_DELEGATE_EXTENSION_CONFIG_ATTRIBUTE_SYSTEMTYPE); } } }
