 define("orion/editor/actions", [ //$NON-NLS-0${  var options = textView.getOptions("tabSize", "expandTab");  //$NON-NLS-0$ var tab = options.expandTab ? new Array(options.tabSize + 1).join(" ") : "\t";  //$NON-NLS-0$  var lineDelimiter = model.getLineDelimiter();  var text = lineText.charCodeAt(end) === 125 ?   lineDelimiter + prefix + tab + lineDelimiter + prefix :  lineDelimiter + prefix + tab;  editor.setText(text, selection.start, selection.end); } 
