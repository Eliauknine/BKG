  if (commentsMap.containsKey("comments")) {  Object[] comments = (Object[]) commentsMap.get("comments");   if (comments.length == 0) {  return (Date[]) result.toArray(); // early return if map is empty; 					}  for (Object o : comments) {  @SuppressWarnings("unchecked") } } }
