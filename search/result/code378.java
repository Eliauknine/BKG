 size_t forte::core::util::transformEscapedXMLToNonEscapedText(char* const paStri{  char toCopy = 0; size_t toMove = 0;  for(size_t i = 0; i < sizeof(forte::core::util::scReplacementForEscapedCharacters) / sizeof(const char* const ); i++){  if(0 == strncmp(runner, forte::core::util::scReplacementForEscapedCharacters[i], strlen(forte::core::util::scReplacementForEscapedCharacters[i]))){           toCopy = forte::core::util::scEscapedCharacters[i];           toMove = strlen(forte::core::util::scReplacementForEscapedCharacters[i]);  break;         }       } } 
