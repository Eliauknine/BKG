  builder.append(getTarget().getClass().getSimpleName()).append(" \"");  builder.append(getObjectLabel(getTarget())).append("\"");   final EMFSymbolFunction function = EMFSymbolFunction.getInstance();  //append the identifier inside the message using symbol function.   builder.append("[").append(function.getSymbol(getTarget())).append("]");   //source however can be single object or tuple  builder.append(") From {");  } }
