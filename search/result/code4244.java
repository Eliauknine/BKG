  while (position < end) { char ch = document.getChar(position);  if (isDelimeter(ch, phpDelimiters)) {  break; 				}  replacementLength++; } }
