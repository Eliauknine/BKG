 public class StringCompressor implements StringIO{  private static final byte DEBUG_INT = 1;  private static final int NULL_ID = 0;  private static final int STRING_FOLLOWS = Integer.MIN_VALUE;  private boolean client;  private int lastID;  private Map<String, Integer> stringToID = new HashMap<String, Integer>();  private Map<Integer, String> idToString = new HashMap<Integer, String>();  /**    * Creates StringCompressor instance.    *  } 
