	 * @return the current offset	 */  public long getOffset() {  return offset; 	}  /** 	 * Given reader, tries to parse an operation and emit it is, 	 * if parsing has been successful. 	 * 	 * @param reader 	 *            the reader that is used to de-serialize operations 	 * @return the successfully parsed operation 	 * @throws IOException 	 *             in case reading from the {@link ReadLineCapable} fails 	 */  public Optional<AbstractOperation> tryEmit(ReadLineCapable reader) throws IOException {  final List<String> readLines = new ArrayList<String>();  withinOperationsElement = false;  String line;  final boolean isForwardDir = direction == Direction.Forward;  while ((line = reader.readLine()) != null && !line.contains(getClosingTag(isForwardDir))) {  if (line.contains(getOpeningTag(isForwardDir))) {  withinOperationsElement = true; 			} else if (withinOperationsElement) {  readLines.add(line); 			}  offset += line.getBytes().length;  offset += NEWLINE_LENGTH; 		}  if (line != null) {  withinOperationsElement = false;  offset += line.getBytes().length; 		}  if (!withinOperationsElement && !readLines.isEmpty()) {  if (direction == Direction.Backward) {  Collections.reverse(readLines); 			}  return Optional.of(deserialize(StringUtils.join(readLines, StringUtils.EMPTY))); 		}  return Optional.absent(); 	}  private String getClosingTag(boolean isForward) { } 
