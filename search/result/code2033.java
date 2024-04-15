  Entry<String, String> entry = (Entry<String, String>) newValue; ctx.set(attributeName + "_"  									+ entry.getKey(), entry.getValue()); 						} else {  ctx.set(attributeName, newValue); 						}
